package com.fdc.db.oracle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import com.fdc.contract.model.FjContractDtl;
import com.fdc.util.JdbcUtils;
import com.fdc.util.MyBasicRowProcessor;

public class OracleSpark {

    public static void main(String[] args) {
        
        SparkConf conf = new SparkConf().setAppName("OracleSpark").setMaster("local");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        
        try {
            Connection conn = JdbcUtils.getDataSource().getConnection();
            
//            String sql = "SELECT * FROM "
//                    + "(SELECT ROWNUM AS rowno, t.* FROM FJ_CONTRACT_DTL_571_201701 t "
//                    + "WHERE ROWNUM <= ?) t2 WHERE t2.rowno >= ?";
            
            String sql = "SELECT * FROM (SELECT t2.*, ROWNUM AS rowno FROM "
                    + "(SELECT t1.* FROM FJ.FJ_CONTRACT_DTL_571_201701 t1 ORDER BY ID) t2 "
                    + "WHERE ROWNUM <= ?) t3 WHERE t3.rowno >= ?";
            
            
            QueryRunner run = new QueryRunner();
            int iStart = 1;
            int iRange = 3000;
            Boolean isMore = true;
            
            int iCount = 1;
            while(isMore) {
                
                List<FjContractDtl> fjContractDtlList = run.query(conn, sql,
                        new BeanListHandler<FjContractDtl>(FjContractDtl.class, new MyBasicRowProcessor()),
                        iStart + iRange - 1, iStart);
                
                if(fjContractDtlList == null || fjContractDtlList.size() == 0 ) {
                    isMore = false;
                    break;
                }
                
                JavaRDD<FjContractDtl> paRdd = jsc.parallelize(fjContractDtlList, 3);
                JavaRDD<String> dtlMap = paRdd.map(dtl -> {
                    return dtl.getId() * 10 + "";
                });
                dtlMap.saveAsTextFile("hdfs://server01:9000/user/aifjs/fjsdb/result/orale-dtl-" + iCount + "-" + iStart + "-" + (iStart + iRange - 1));
                
                iStart += iRange;
                iCount++;
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jsc.close();
        }
    }

}
