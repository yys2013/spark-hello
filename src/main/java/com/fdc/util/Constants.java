package com.fdc.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class Constants {
	private  Constants(){}
	
	private final static Long SYSTEM_COMM_TENANT_ID = 9999L;
	private final static String DEFAULT_CATEGORY = "SYSTEM";
	private final static String DEFAULT_PARAM_VALUE = "SYSTEM_TENANT_ID";
	private final static String TENANT_GROUP_PARAM = "TENANT_ID_GROUP";
	private final static Long TENANT_ID = 11L;
	public static final List<Integer> RECON_FILTER = new ArrayList<Integer>();//对账需要过滤的数据
	//add by zhoulz，年度月份数常量
	public static final int MONTH_NUMBER = 12;
	public static final int NORMAL_STS = 1;
	public static final int CANCEL_STS = 0;
	
	//默认的 tenant_id
//	public final static Long DEFAULT_TENANT_ID;
//	
//	public final static long[] TENANT_ID_GROUP;
	//地市县市加载map
	public final static Map<String, String> REGION_MAP = new HashMap<String, String>();
	public final static Map<String, String> CUNTRY_MAP = new HashMap<String, String>();
	
	static{
//		//初始化系统tenant_id
//		FcParam entity = new FcParam();
//		entity.getQuery().addCondition(FcParam.Field.tenantId,Operator.EQUALS,SYSTEM_COMM_TENANT_ID);
//		entity.getQuery().addCondition(FcParam.Field.paramCategory,DEFAULT_CATEGORY);
//		entity.getQuery().addCondition(FcParam.Field.paramValue, DEFAULT_PARAM_VALUE);
//		ApplicationContext atc = FJSSpringContext.getContext();
//		CommonDao paraDao = atc.getBean(CommonDao.class);
//		entity = (FcParam) paraDao.load(entity);
//		DEFAULT_TENANT_ID = Long.valueOf((entity==null?TENANT_ID:entity.getParamCode())+"");
//		//初始化tenant_id_group
//		if(entity==null){
//			entity = new FcParam();
//		}
//		entity.getQuery().clearQuery();
//		entity.getQuery().addCondition(FcParam.Field.tenantId,Operator.EQUALS,DEFAULT_TENANT_ID);
//		entity.getQuery().addCondition(FcParam.Field.paramCategory,DEFAULT_CATEGORY);
//		entity.getQuery().addCondition(FcParam.Field.paramValue, TENANT_GROUP_PARAM);
//		entity = (FcParam) paraDao.load(entity);
//		String[] tenantGroup = ((entity == null ? TENANT_ID:entity.getParamCode())+"").split(",");
//		TENANT_ID_GROUP = new long[tenantGroup.length];
//		for(int i=0;i<tenantGroup.length;i++){
//			TENANT_ID_GROUP[i] = Long.valueOf(tenantGroup[i]);
//		}
//		RECON_FILTER.add(9);
//		RECON_FILTER.add(20);
//		RECON_FILTER.add(21);
//		
//		//地市
//		if(entity==null){
//			entity = new FcParam();
//		}
//		List<FcParam> paramList = new ArrayList<FcParam>();
//		entity.getQuery().clearQuery();
//		entity.getQuery().addCondition(FcParam.Field.tenantId,Constants.DEFAULT_TENANT_ID);
//		entity.getQuery().addCondition(FcParam.Field.paramCategory, "REGION_CODE");
//	    paramList = paraDao.find(entity);
//	    for(FcParam temp : paramList) {
//	    	REGION_MAP.put(temp.getParamCode(), temp.getParamValue());
//	    }
//		//县市
//		List<FcCounty> countyList = new ArrayList<FcCounty>();
//		Query<FcCounty> query = QB.create(FcCounty.class);
//		countyList = paraDao.find(query.getInstance());
//		for (FcCounty temp : countyList) {
//			CUNTRY_MAP.put(temp.getCountyCode(), temp.getCountyName());
//		}
	}
		
	public final static int MSG_LENGTH = 255;//error信息长度
	
	public static final class TransCode{
		private TransCode() {
		}
		/**
		 * trans_code交易码定义
		 */
		public static final long BILLED_RC             	  =	10010001 ; 	
		public static final long BILLED_USAGE          =	10010002 ; 	
		public static final long BILLED_OTC               =	10010003 ; 	
		public static final long BILLED_VAT               =	10010004 ; 	
		public static final long BILLED_DISCOUNT    =	10010005 ; 	
		public static final long BILLED_CASH             =	10010006 ; 
		public static final long BILLED_DEFERRED     =	10010007 ;
		public static final long DISCOUNT_DEFERRED     =	10010016 ; 		
		public static final long CANCEL_BILLED_RC             	  =	10010008 ; 	
		public static final long CANCEL_BILLED_USAGE          =	10010009 ; 	
		public static final long CANCEL_BILLED_OTC               =	10010010 ; 	
		public static final long CANCEL_BILLED_VAT               =	10010011 ; 	
		public static final long CANCEL_BILLED_DISCOUNT    =	10010012 ; 	
		public static final long CANCEL_BILLED_CASH             =	10010013 ; 
		public static final long CANCEL_BILLED_DEFERRED     =	10010014 ;
		public static final long BILLED_INVOICE               =1001;
		                                            
		public static final long UNBILLED_RC    =	20010001 ; 	
		public static final long UNBILLED_USAGE      =	20010002 ; 	
		public static final long UNBILLED_OTC           =	20010003 ; 
		public static final long UNBILLED_ROLLOVER           =	20010004;
		public static final long UNBILLED_DISCOUNT           =	20010005;			
		public static final long UNBILLED_INVOICE               =2001;
		
		public static final long PPS_RC                			=	50010001 ; 	
		public static final long PPS_USAGE             	=	50010002 ; 	
		public static final long PPS_OTC               		=	50010003 ; 	
		public static final long PPS_DISCOUNT              =	50010004 ;
		public static final long PPS_VAT               		=	50010005 ; 	
		public static final long PPS_CASH               		=	50010006 ;
		                                  
		//payment		 	
		public static final long UNION_PAYMENT         		    =	30018001; 
		public static final long CANCEL_UNION_PAYMENT 	=	30018002;			
		public static final long COLLECT_PAYMENT       			=	30018003; 
		public static final long CANCEL_COLLECT_PAYMENT	=	30018004; 		 	
		public static final long ADVANCE_PAYMENT       			=	30018005;
		public static final long CANCEL_ADVANCE_PAYMENT=	30018006;
		public static final long UNDEFINED_PAYMENT 			 =	30018007;
		public static final long CANCEL_UNDEFINED_PAYMENT=30018008;
		public static final long UNDEFINED_PAYREPAY  			 =30018009;
		public static final long WRITEOFF_PAYMENT  			 	 =30018011;
		public static final long CANCEL_WRITEOFF_PAYMENT =30018012;
		public static final long DIRECT_DEBIT_PAYMENT  		 =30018013;
		public static final long ASYN_DEDUCT_PAYMENT  		 =30018015;
		public static final long CANCEL_ASYN_PAYMENT  		 =30018016;
		public static final long BATCH_DEDUCT_BILL 		 		 =30018017;
		public static final long UNDEFINED_PAYREFUND  		 =30018019;
		public static final long CANCEL_UNDEFINED_PAYREFUND=30018020;
		public static final long DEBIT_PAYMENT_OUT            		=	30018021; 
		public static final long CANCEL_DEBIT_PAYMENT_OUT =	30018022;
		public static final long DEBIT_PAYMENT_IN        			    =	30018023; 
		public static final long CANCEL_DEBIT_PAYMENT_IN     =	30018024;
		public static final long ADVANCE_PAYMENT_TO_OVERPAYMENT     =	30018025;
		public static final long DROP_FINAL_BILL                          =	30018027;
		public static final long PAYMENT_TRANSFER_OUT                         =	30018031;
		public static final long PAYMENT_TRANSFER_IN                       =	30018032;
		public static final long DOUBLE_BOOKING_PAYMENT       			=30018099; 
		public static final long CANCEL_DOUBLE_BOOKING_PAYMENT         	=30018088; 
		
		
		//bill adjust
		public static final long ADJUST_UNBILLED           			=	30014001; 		
		public static final long ADJUST_BILLED		              		=	30014003; 	
		public static final long WRITE_OFF 			  						=	30014005; //到 bill adjustment
		public static final long CANCEL_WRITE_OFF 			  	=	30014006; //到 bill adjustment
		public static final long CANCEL_INVOICE             			= 30014008;//cancel
		public static final long ADJUST_REGRET           			    =30014009; 
		public static final long DOUBLE_BOOKING_WRITE_OFF       	    =30014099; 
		public static final long CANCEL_DOUBLE_BOOKING_WRITE_OFF        =30014088; 
		
		public static final long DOUBLE_BOOKING_ADVANCE_PAYMENT      	    =30018051;  //预缴的钱，税金额批扣跟异步销账时要做double booking
		public static final long CANCEL_DOUBLE_BOOKING__ADVANCE_PAYMENT        =30018052; 
		
		//balance adjust
		public static final long ADJUST_BALANCE               		=	30015001; 	
		public static final long CANCEL_BALANCE        			=	30015002; 	
		public static final long TRANSFER_BALANCE              	=	30015003; //一个流水号有两笔交易 1转入2转出 
		public static final long CANCEL_TRANSFER_BALANCE=	30015004; //取消转移转换
		public static final long REFUND 				  						=	30015005; //退款,  到 balance adjustment
		public static final long CANCEL_REFUND 				  		=	30015006; //退款,  到 balance adjustment
		public static final long DOUBLE_BOOKING_BAL_ADJUSTMENT       	    =30015099; 
		public static final long CANCEL_DOUBLE_BOOKING_BAL_ADJUSTMENT        =30015088; 
		
		
		//topup
		public static final long TOP_UP                						=	30011001 	;	
		public static final long CANCEL_TOP_UP                		=	30011002 	;		
		public static final long DEPOSIT 			  							=	30011005  ; 
		
		//installment
		public static final long INSTALLMENT           					=	30012001 	;	
		public static final long CANCEL_INSTALLMENT           =	30012002 	;
		public static final long CANCEL_BILL_INSTALL             =	30012004 	;
		public static final long ADVANCE_INSTALL                   =	30012005 	;
		public static final long ERROR_HANDLING                    =	30012007 	;
		public static final long MOVE_INSTALL                          = 30012009 	;
		
		//retail
		public static final long SHOP_SALE 							    = 30019001;
		public static final long CANCEL_SHOP_SALE			    = 30019002;
		public static final long REGRET_ORDER         				    =	30019003; 
		public static final long REPAIR_ORDER         				    =	30019005; 
		
		
		//expbalance                                           
		public static final long EXP_BALANCE           					=	60011001	;	
		//impairment
		public static final long IMPAIRMENT_CAL            					=	60012001	;
		public static final long IMPAIRMENT_INSTAL            				=	60012002	;
		public static final long IMPAIRMENT_BANKRUPT            		=	60012003	;
		//dunning
		public static final long DUNNING                              =  10010015   ;
		
		//edi
		public static final long EDI_DEFFER                              =  70010001   ;
		public static final long EDI                              =  70010002   ;
		
		//SETTLEMENT
		public static final long INTERCONNECT_VOICE_IN  			  		= 70010013;  	// FJ.FJ_IC_IN
		public static final long INTERCONNECT_SMS_IN  						= 70010014;	// FJ.FJ_IC_IN
		public static final long INTERCONNECT_MMS_IN  					= 70010015;	// FJ.FJ_IC_IN
		public static final long INTERCONNECT_VOICE_OUT   			  	= 70010003;	//FJ.FJ_IC_VOICE
		public static final long INTERCONNECT_SMS_OUT  					= 70010004;	//FJ.FJ_IC_SMS
		public static final long INTERCONNECT_MMS_OUT 					= 70010005;	//FJ.FJ_IC_MMS
		
		public static final long ROAMING_VOICE_IN						= 70010006;			//FJ.FJ_ROAMING_IN
		public static final long ROAMING_SMS_IN 						= 70010007;			//FJ.FJ_ROAMING_IN
		public static final long ROAMING_GPRS_IN 						= 70010008;			//FJ.FJ_ROAMING_IN
		public static final long ROAMING_VOICE_OUT					= 70010010;			//FJ.FJ_ROAMING_OUT
		public static final long ROAMING_SMS_OUT 						= 70010011;			//FJ.FJ_ROAMING_OUT
		public static final long ROAMING_GPRS_OUT 					= 70010012;			//FJ.FJ_ROAMING_OUT
		
		public static final long THIRD_PARTY_COST 						= 70010009;	
		
		//WHOSALE
		public static final long WHOSALE_USAGE                        =80010001;
		public static final long WHOSALE_RC                         =80010002;
		public static final long WHOSALE_OTC                         =80010003;
		public static final long WHOSALE_DIFF                         =80010004;
		
		/** 表：fj_i15_inv */
		public static final long ZJ_CONTRACT_INV                        =40010001;
		public static final long CONTRACT_CONTRACT_DEFERRED                        =40010002;
		public static final long CONTRACT_ALLOCATION_REVENUE                        =40010003;
		
		/** IFRS15收入，包括终端和通信 表：fj_contract_alloc*/
		public static final long ZJ_I15_ALLOC_REVENUE                      =40010005;
		
		//CMC-BOSS模拟一个合约的一个会计月的现金流，永远大于等于0，表：fj_i15_inv_rev
		public static final long ZJ_CRT_INV_REV_CASH_REVENUE                         =40010004;
		//主营业务，保底减去折扣折让，表：fj_i15_inv_rev
		public static final long ZJ_CRT_INV_REV_MAIN_SERVICE_REVENUE           =40010006;
		public static final long ZJ_CRT_INV_REV_TERMINAL_SERVICE_REVENUE           =40010007;
		//预收账款发生额，表：fj_i15_inv_rev
		public static final long ZJ_CRT_INV_REV_PRE_ADJ_REVENUE					=40010008;
		//终端补贴分摊额，表：fj_i15_inv_rev
		public static final long ZJ_CRT_INV_REV_TERMINAL_ALLO                 =40010009;
		/** 浙江 IFRS15 酬金收入,表：fj_rtl_reward_info */
		public static final long ZJ_REWARD_REVENUE           =40020001;
	
		
	    
		
	
	}
	
	
	
	public static final class OnlineBusiSpecId {
		private OnlineBusiSpecId() {
		}
		
		public static final int COLLECT_PAYMENT=8011;
		public static final int CANCEL_COLLECT_PAYMENT=8012;
		public static final int WRITEOFF_PAYMENT=8031;
		public static final int CANCEL_WRITEOFF_PAYMENT=8032;
		public static final int DEBIT_PAYMENT_OUT=9101;
		public static final int CANCEL_DEBIT_PAYMENT_OUT=9102;
		public static final int DEBIT_PAYMENT_IN=9111;
		public static final int CANCEL_DEBIT_PAYMENT_IN=9112;
		public static final int ADVANCE_PAYMENT=8291;
		public static final int DIRECT_DEBIT_PAYMENT=10101;
		public static final int ASYN_DEDUCT_PAYMENT=8531;
		public static final int CANCEL_ASYN_PAYMENT=8532;
		public static final int BATCH_DEDUCT_BILL=8471;
		public static final int DROP_FINAL_BILL=8961;
		public static final int PAYMENT_TRANSFER_IN=8521;
		public static final int PAYMENT_TRANSFER_OUT=8192;
		public static final int UNDEFINED_PAYMENT=9931;
		public static final int CANCEL_UNDEFINED_PAYMENT=9932;
		public static final int UNDEFINED_PAYREPAY=9951;
		public static final int ADVANCE_PAYMENT_TO_OVERPAYMENT=8161;
		
		public static final int ADVANCE_INSTALL=8601;
	
		
	}
	/**
	 * 合同升级时IsUpgrade字段的枚举值
	 */
	public static final class IsUpgrade{
		private  IsUpgrade() {
		}
		/**原始合同   */
		public static final Integer ORIGINAL=0;
		/**升级合同*/
		public static final Integer UPGRADE=1;
	}
	
	
	/**
	 * 合同升级时IsUpgrade字段的枚举值
	 */
	public static final class FiscalPeriodDate{
		private  FiscalPeriodDate() {
		}
		/**会计期开始时间   */
		public static final String START_DATE="startDate";
		/**会计期结束时间——valueDate*/
		public static final String END_DATE="endDate";
		/**该会计期出账时间*/
		public static final String BILL_DATE="billDate";
	}
	
	
	/**
	 * 保底生效当月的收入规则
	 */
	public static final class CycleFreq{
		private  CycleFreq() {
		}
	    /**折天算  */
		public static final Integer CAL_DAYS=-5;
		/**按月算   */
		public static final Integer CAL_WHOLE_MONTH=1;
		/**按半月算  以15号为界  */
		public static final Integer CAL_HALF_MONTH=2;
		/**取不到前面三种情况，默认9，折天算  */
		public static final Integer NORMAL=9;
	}
	
	/**
	 * 合约类型。
	 * 101：自营终端捆绑合约（IFRS15计算）
	 * 102：第三方铺货终端捆绑合约（IFRS15计算）
	 * 103：引商入柜终端捆绑合约
	 * 104：第三方模式终端捆绑合约
	 * 105：其他模式终端捆绑合约
	 * 201：宽带融合合约
	 * 301：裸宽包年合约
	 * 401：无终端有保底合约
	 * 501：无终端无保底合约
	 * 601：无终端无保底长期
	 * 701：其他
	 * @author sky
	 *
	 */
    public static final class OrderType{
        private  OrderType() {
        }
        /**101：自营终端捆绑合约（IFRS15计算） */
        public static final int TERMINAL_SELF_SUPPORT = 101;
        /**102：第三方铺货终端捆绑合约（IFRS15计算） */
        public static final int TERMINAL_THIRD_PARTY_DISTRIBUTION = 102;
        /**103：引商入柜终端捆绑合约 */
        public static final int TERMINAL_LEAD_CABINET = 103;
        /**104：第三方模式终端捆绑合约 */
        public static final int TERMINAL_THIRD_PARTY_MODEL = 104;
        /**105：其他模式终端捆绑合约 */
        public static final int TERMINAL_OTHER_MODEL = 105;
        /**201：宽带融合合约 */
        public static final int BROADBAND_INTEGRATION = 201;
        /**301：裸宽包年合约 */
        public static final int BROADBAND_WHOLE_YEAR = 301;
        /**401：无终端有保底合约 */
        public static final int NO_TERMINAL_HAVE_GUARANTEE = 401;
        /**501：无终端无保底合约 */
        public static final int NO_TERMINAL_NO_GUARANTEE = 501;
        /**601：无终端无保底长期 */
        public static final int NO_TERMINAL_NO_GUARANTEE_LONG = 601;
        /**701：其他 */
        public static final int ORTHER_TYPE = 701;
    }
	
	public static final class CmcChargeType{
		private  CmcChargeType() {
		}
		public static final Integer CASH_FLOW=8888;
	    //终端
		public static final Integer TERMINAL=1001;
	    //预存
		public static final Integer ADVANCE_DEPOSIT=1002;
		//包年类型保底
		public static final Integer YEAR_GUARANTEED_FEE=1003;
		//保底
		public static final Integer GUARANTEED_FEE=1004;
		//缴费卡
		public static final Integer PAYMENT_CARD=1005;
	
		//馈赠金
		public static final Integer GIFTS_GOLD=1006;
		
		//电子券
		public static final Integer ELECTRONIC_SECURITIES=1007;
		//实物
		public static final Integer ENTITY=1008;
		//终端补贴
		public static final Integer TERMINAL_ALLOWANCE=1009;
		//酬金
		public static final Integer REWARD=8001;
		//促销积分
		public static final Integer PROMOTION_POINTS=9001;
	}
	
	
	/**
	 * 返还规则中的返还账本类型
	 */
	public static final class DepositAccountType {
		private DepositAccountType() {
		}
		/** 本金*/
		public static final Integer  ADVANCE_DEPOSIT= 2001;
		/** 馈赠金*/
		public static final Integer GIFTS_GOLD = 2101;
	
	}
	
	
	/**
	 * 返充的规则  目前用到0467  ，238不用
	 */
	public static final class DepositReturnType {
		private DepositReturnType() {
		}
		/**一次性充值 */
		public static final Integer  DISPOSABLE= 0;
		/**周期性处理，按周期固定充值 */
		public static final Integer PERIODICITY = 4;
		/** 按计划充值 类似周期性*/
		public static final Integer ACCORDING_TO_PLAN = 6;
		/**一次性立即充值 */
		public static final Integer DISPOSABLE_INSTANT = 7;
		
		
		/**目前不用 */
		/**根据月账单 */
		public static final Integer ACCORDING_TO_MONTH_BILL = 2;
		/** 根据日充值*/
		public static final Integer ACCORDING_TO_DAILY = 3;
		/**特殊预缴充值 */
		public static final Integer SPECIAL = 8;
	
	}
	
	
	/**
	 * 合同升级时ContractItemType字段的枚举值
	 */
	public static final class ContractItemType{
		private ContractItemType(){
		}
		/**升级合同  */
		public static final Integer UPDATE=1;
		/**原先的合同 */
		public static final Integer NEW=0;
	}
	
	
	/**
	 * 各表中deal sts字段的枚举值
	 */
	public static final class DealSts {
		private DealSts() {
		}

		/** 初始状态，未处理状态 */
		public static final Integer NORMAL = 0;
		
		/** 数据处理成功 */
		public static final Integer SUCCESS = 1;
		
		/** 处理失败的数据。比如找不到mapping 规则的数据， */
		public static final Integer FAIL = 2;
		
		/** 对账失败的数据 */
		public static final Integer RECONCILIATION_FAIL = 3;
		
		/** 忽略的数据。流程处理的时候，某些数据是不符合我们的要求的，但是这些数据又不能算作错误数据，同时也不应影响流程的执行 */
		public static final Integer IGNORE_DATA = 4;
		
	}
	
	/**
	 * 接口表中error code字段的枚举值
	 */
	public static final class ErrorCode {
		private ErrorCode() {
		}
		
		/** 0：正常数据 */
		public static final int DEFAULT_SUCC = 0;
		
		/** 1001：合同期限超过了6年，close_date/create_date */
		public static final int CONTRACT_EXCESS = 1001;
		
		/** 1002: 生效期超过6个月，create date/当前时间 */
		public static final int CONTRACT_VALID_EXCESS = 1002;
		
		/** 1003：合同总价格为0或负值 */
		public static final int CONTRACT_FEE = 1003;
		
		/** 1004：终端的办理时间和结束时间不在同一天 */
		public static final int TERMINAL_DATE = 1004;
		
		/** 1005：保底费用的独立售价为0或为null */
		public static final int GUARANTEED_FEE = 1005;
		
		/** 1006：终端的独立售价为0或为null */
		public static final int TERMINAL_FEE = 1006;
		
		/** 1007：馈赠金与有价卡总额超过合约保底总额 */
		public static final int PAYMENT_FEE_EXCESS = 1007;
		
		/** 1099：总的ssp为0 */
		public static final int SSP_FEE = 1099;
		
		/** 数据内容异常 */
		public static final int DATA_ERROR = 9000;
		
		/** 9999其他异常的Order数据 */
		public static final int OTHER = 9999;
		/** 1100无保底合约有保底数据 */
		public static final int HAS_GUARANTEED = 1100;
		
	}

	/**
	 * 各表中IsDeferredContract字段的枚举值
	 */
	public static final class IsDeferredContract {
		private IsDeferredContract() {
		}
		/** 原始合同 */
		public static final Integer ORIGINAL_CONTRACT = 0;
		/** 递延合同*/
		public static final Integer DEFERRED_CONTRACT = 1;
	
	}
	
	
	/**
	 * 各表中alloc sts字段的枚举值
	 */
	public static final class AllocSts{
		private  AllocSts() {
		}
		/**合同的收入还在确认中*/
		public static final Integer OPEN=0;
		/**合同的收入确认完了,但是还在alloc表中*/
		public static final Integer CLOSING=1;
		/**合同的收入确认完了，且alloc迁移到了alloc_history表中*/
		public static final Integer CLOSED=2;
	}
	
	/**
	 * 各表中sum sts字段的枚举值
	 */
	public static final class SumSts{
		private SumSts(){
		}
		/** 合同还未沉淀*/
		public static final Integer NOT_ACCUMULATED=0;
		/** 合同已经沉淀*/
		public static final Integer ALREADY_ACCUMULATED=1;
		
		/** 处理失败，程序异常 */
		public static final Integer FAIL_EXCEPTION = 9;
		
		/** 处理失败，数据异常 */
		public static final Integer FAIL_DATA = 2;
	}
	/**
	 * 各表中contract type字段的枚举值
	 */
	public static final class ContractType{
		/**限定在该协议期内不允许再次办理优惠购机业务,新合同默认为1 */
		public static final Long NEWPHONE=1L;
		/**签订的基本套餐协议期 */
		public static final Long SUBSCRIPTION=2L;
		/**增值策划的协议期 */
		public static final Long SERVICE=3L;
	}
	
	
	
	/**
	 * 各表中contract level字段的枚举值
	 */
	public static final class ContractLevel{
		/** user level */
		public static final Integer USER_LEVEL=1001;
		/** acct level*/
		public static final Integer ACCT_LEVEL=2001;
		/**cust level */
		public static final Integer CUST_LEVEL=3001;
		/**group level */
		public static final Integer GROUP_LEVEL=4001;
		/**order level */
		public static final Integer ORDER_LEVEL=5001;
	}
	
	
	/**
	 * 
	 * 
	 * 账本类别定义
	 */
	public static final class BalanceType {
		private BalanceType() {
		}

		/** normal balance pocket */
		public static final Integer NORMAL_BALANCE = 1;
		
		/** reward pocket */
		public static final Integer REWARD_BALANCE = 2;
		
		/** migrated balance pocket */
		public static final Integer MIGRATED_BALANCE = 3;
		
		/** advance payment pocket */
		public static final Integer ADVANCE_BALANCE = 4;
	}
	
	/**
	 * 
	 * 区分是月账户还是季度账户还是retailinvoice账户(第二天出账)
	 * @author Administrator
	 *
	 */
	public static final class AccountState {
		private AccountState() {
		}

		public static final int MONTHLY_ACCOUNT=0;
		
		
		public static final int QUARTERLY_ACCOUNT=1;
		
		
		public static final int RETAIL_INVOICE_ACCOUNT=2;

	}
	
	/**
	 * 过滤科目场景的枚举值
	 */
	public static final class FilterItemCode {
		private FilterItemCode() {
		}

		
		public static final String UNBILLED = "unbilled";
		
		
		public static final String DEFERRED ="deferred";
	}
	
	/**
	 * 合同的一些字段
	 */
	public static final class ContractColumn{
		private ContractColumn() {
		}
		public static final String CONTRACT = "CONTRACT";
		public static final String CONTRACT_TYPE = "CONTRACT_TYPE";
		public static final String CONTRACT_LEVEL ="CONTRACT_LEVEL";
        public static final String CHARGE_TYPE = "CHARGE_TYPE";
		public static final String ALLOC_STS ="ALLOC_STS"; 
		public static final String IS_UPGRADE ="IS_UPGRADE"; 
		public static final String CONTRACT_ITEM_TYPE ="CONTRACT_ITEM_TYPE"; 
	}
	
	
	
	public static final Integer BatchCount=500;//每次处理条数
	public static final Integer OnlineBatchCount=3000;//在线交易每次处理条数
	public static final Integer STANDARD = 0;
	public static final Integer ACCRUALS=1;
	public static final Integer DEFFERED=2;
	public static final Integer LIMITED=0;//按使用量计算
	public static final Integer UNLIMITED=1;//按天计算
	
	
	public static final class CashItemType {
		private CashItemType() {
		}

		/** 需要拆分的 dunning 费用 */
		public static final int FOR_DUNNING = 1;
		
		/** Hu billed 不算作收入的科目:滞纳金、罚金 */
		public static final int FOR_NON_REVENUE_BILLED_HU = 2;

		/** HU  online不算作收入的科目：利息、罚金 */
		public static final int FOR_NON_REVENUE_ONLINE_HU = 3;
		
		/** 有些科目不需要拆分 defer */
		public static final int FOR_DEFER = 4;

		/** 有些科目不需要计算 unbilled 费用 */
		public static final int FOR_UNBILLED = 5;
		
		/** 后付费为预付费充值的特殊item_code */
		public static final int TOP_UP_ON_PREPAID = 6;
		
		/** 两借两贷的item_code */
		public static final int HU_DOUBLE_BOOKING =7;
	}
	
	
	public static final class AsynBatchDeductResourceType{
		private AsynBatchDeductResourceType() {
		}
		public static final int UNKNOW_SOURCE = 0;
		
		public static final int OVER_PAYMENT = 1;
	
		public static final int ADVANCE_PAYMENT = 2;
		
		public static final int CREDIT_NOTE= 3;
	}
	
	
	public static final class DifferentCountriesOnlineLogic{
		private DifferentCountriesOnlineLogic() {
		}
		public static final int BASE_ONLINE_LOGIC =0;
		public static final int DK_ONLINE_LOGIC =1;
		public static final int HU_ONLINE_LOGIC =2;
		public static final int EXTEND1_ONLINE_LOGIC =3;
		public static final int EXTEND2_ONLINE_LOGIC =4;
		public static final int EXTEND3_ONLINE_LOGIC =5;
		
	}
	
	
	
	
	
	
	/**
	 * 
	* @ClassName: RevType 
	* @Description: 收入类型 
	* @author cenxx
	* @date 2014-6-4 下午05:03:20 
	*
	 */
	public static final class RevType{
		private RevType() {
		}
		public static final Integer REV_TYPE_USAGE=0;// 使用费
		public static final Integer REV_TYPE_RC=1;//固费
		public static final Integer REV_TYPE_OTC=2;//一次性费用
		public static final Integer REV_TYPE_DISCOUNT=4;//计费优惠
		public static final Integer REV_TYPE_VAT=5;//税
	}
	/**
	 * 
	 * @Description:调账类型
	 * @author huqx
	 *
	 */
	public static final class AjustType{
		private AjustType() {
		}
		public static final int FULL_INVOICE_AJUST = 1;//全账单调账
		public static final int NO_INVOICE_AJUST = 2;//无账单调账
		public static final int ITEM_AJUST = 3;//科目级调账
	}
	/**
	 * 
	* @ClassName: FeeType 
	* @Description: 费用类型 
	* @author cenxx
	* @date 2014-6-5 下午04:15:46 
	*
	 */
	public static final class FeeType{
		private FeeType() {
		}
		public static final int  FEE_TYPE_USAGE=0;//-话单费用
		public static final int  FEE_TYPE_BILL_DISCOUNT=1;//账务优惠费用 
		public static final int  FEE_TYPE_OTC=2;//产品订购的一次性费用
		public static final int  FEE_TYPE_RC=3;//3-周期性费用
		public static final int  FEE_TYPE_ADJUST=4;//4-调整费用
		public static final int  FEE_TYPE_VAT=5;//5- 税费
		public static final int  FEE_TYPE_EXT=6;//6- 外部费用
		public static final int  FEE_TYPE_RATING_DISCOUNT=7;//7- 计费优惠费用

	}
	
	/**
	 * 
	* @ClassName: CalUnBilledRcType 
	* @Description: 计算类型
	* @author gezq
	* @date 2016-4-15 上午11:15:46 
	*
	 */
	public static final class CalUnBilledRcType{
		private CalUnBilledRcType() {
		}
		public static final int  CAL_UNBILLED_RC_TYPE1=1;
		public static final int  CAL_UNBILLED_RC_TYPE2=2;
		public static final int  CAL_UNBILLED_RC_TYPE3=3;
		public static final int  CAL_UNBILLED_RC_TYPE4=4;
		public static final int  NOT_CAL_UNBILLED_RC=5;
	

	}
	
	public static final class TableFlag{
		private TableFlag() {
		}
		public static final Integer  TABLE_POCKET=1;//帐本
		public static final Integer  TABLE_WALLET = 8;//周期性免费资源
	}
	
	public static  final class Statistics{
		private Statistics() {
		}
		public static final String  MAPPING_TRANSCODE_LIST="mapping_transcode_list-01";//帐本
	}
	
	public static final class InitDate{
		private InitDate() {
		}
		public static final String  ONLINE_START_DATE="1970-01-01 08:00:00";//在线交易初始日期
	}
	
	/**
	 * 用于DBM上流程的返回值
	 * http://10.10.10.141/svn/svnfiles/doc/product/framework/design/sdl/新产品架构-SDL语言开发指南.doc 
	 * <p>
	 *  其他返回值	认为接口处理失败，回滚事务。是否重做根据平台配置决定。
	 *	如果流程抛出CAIException异常,认为接口处理失败，回滚事务。是否重做根据平台配置决定。
	 *	（具体错误号分配，见http://10.10.10.141/svn/svnfiles/doc/product/cloudplatform/ver1/references/业务开发日志使用.doc
	 * </p>
	 */
//	public static final class SucFlag {
//		private SucFlag() {
//		}
//		/** 成功，结果将被流转到下一个节点 */
//		public static final Integer SDL_OK = OBBufferErrorException.SDL_OK;
//		
//		/** 系统级错误，表示该TS已无法继续处理其他任务。当前任务丢失，并自动重启TS。 */
//		public static final Integer SDL_FAIL = OBBufferErrorException.SDL_FAIL;
//		
//		/** 表示该接口在TS中只运行一次，其结果将被流转到下一个节点。 */
//		public static final Integer SDL_ONCE = OBBufferErrorException.SDL_ONCE;
//		
//		/** 表示流程中止，后续的接口和TS均不再被调用到，并且回滚已处理的事务。（该处后续会调整成提交已处理的事务） */
//		public static final Integer SDL_DISCARD = OBBufferErrorException.SDL_DISCARD;
//		
//		/** 仅平台使用，表示该TS事务处理失败，需回滚并走稽核。 */
//		public static final Integer SDL_TRANS_FAIL = OBBufferErrorException.SDL_TRANSACTION_FAILURE;
//		
//		/** 表示本次处理失败，需由TS先回滚事务后，重做该TS */
//		public static final Integer SDL_TRANS_REDO = OBBufferErrorException.SDL_REDO;
//
//	}
	/**
	 * 
	* @ClassName: JobParams 
	* @Description: 流程自定义参数。 
	* @author cenxx
	* @date 2014-8-1 上午11:08:42 
	*
	 */
	public static final class JobParams{
		private JobParams() {
		}
		public static final String TENANT_ID = "tenant_id";
		public static final String TRANS_CODE = "trans_code";
		public static final String REGION_CODE = "region_code";
		public static final String TRANS_TYPE = "trans_type";
		public static final String BILL_DATE = "bill_date";
		public static final String FISCAL_PERIOD = "fiscal_period";
		public static final String UNBILL_DATE= "unbill_date";
		public static final String ACC_ID= "acct_id";
		public static final String IMPAIRMENT_DATE= "impairment_date";
		public static final String VALUE_DATE = "value_date";
		public static final String TRANS_DATE = "trans_date";
		public static final String REPORT_ID = "report_id";
		public static final String COLLECT_TYPE = "collect_type";
	}
	
	/**
	 * 
	* @ClassName: TransType 
	* @Description: 1 normal_transaction
2 manually adjustment transaction 
	* @author cenxx
	* @date 2014-8-4 下午08:49:11 
	*
	 */
	public static final class TransType{
		private TransType() {
		}
		public static final int  NORMAL_TRANSCATION=1;
		public static final int  MANUALLY_ADJUSTMENT_TRANSACTION=2;
	}
	
	public static  final class FreeResType{
		private FreeResType() {
		}
		public static final short  ACCT_LEVEL=1;
		public static final short  RESOURCE_LEVEL=2;
	}
	
	public static final class AmountType{
		private AmountType(){}
		public static final short INSTALL_AMOUNT=	1;
		public static final short DOWN_PAYMENT=	2;
		public static final short  NET_PRESENT_AMOUNT=3;

	}
	
	public static final class VatReportBillType{
		private VatReportBillType(){}
		public static final int	ADVANCE_PAYMENT=22;
		public static final int CREDIT_NOTE=9;
		public static final int	POST_PAID=1234;
		public static final int	SUMMARY=99;
	}
	
	public static final class VatReportBillingType{
		private VatReportBillingType(){}
		public static final int PRE_PAID=0;
		public static final int POST_PAID=1;
		public static final int COMMON=-1;
	}
	
	public static final class IsValid
	{
		private IsValid(){}
		public static final short VALID = 1;
		public static final short INVALID = 0;
	}
	
	public static final class DiscountRefType
	{
		private DiscountRefType(){}
		public static final short FJ_DISCOUNT_REF = 0;
		public static final short FJ_SEG_DISCOUNT_REF = 1;
		public static final short FC_ENTITY_DIMENSION = 2;
	}
	
	public static final class DiscountSts
	{
		private DiscountSts(){}
		public static final int STS_HANDLE_NO = 0;
		public static final int STS_HANDLE_SUCCEED = 1;
		public static final int STS_HANDLE_FAIL = 2;
		public static final long DICOUNT_FOR_B2C=1;
		public static final long DICOUNT_FOR_B2B=2;
	}

	public static final class FlowStsConstants {
		private FlowStsConstants() {
		}
		public static final int MSG_MAX_LENGTH = 255;

		public static enum Sts {
			IN_PROGRESS(201, "In Progress"), /** */
			FULL_SUCCESS(300, "Full Success"), /** */
			SUCCESS_BUT_SOME_DATA_ERROR(301, "success but some data error"), /** */
			FAIL(400, "fail"), /** */
			DELETE_FAIL(403, "delete fail"), /** */
			DELETE_SUCCESS(401, "delete success");

			public int code;
			public String desc;

			Sts(int c, String des) {
				this.code = c;
				this.desc = des;
			}
		}
	}

	public static final class FlowName{
		private FlowName() {
		}
		public static final String DT_FILE_SCAN_ONLINE = "fjs_dt_file_scan_online";
		public static final String ONLINE_RUN = "fjs_online_run";
		
		public static final String BILLEDINV_TO_JOURNALS_JAVA = "fjs_billedInv_to_journals_java";
		public static final String BILLED_TO_DETAIL = "fjs_billed_to_detail";
		public static final String BILLED_SPLIT_DISCOUNT = "fjs_billed_split_discount";
		public static final String OTC_SPLIT = "fjs_otc_split";
		public static final String BILLED_RUN_JAVA = "fjs_billed_run_java";
		
		public static final String OFFLINE_UNBILLED_AGING_CAL = "fjs_offline_unbilled_aging_cal";
		public static final String OFFLINE_AGING_CAL = "fjs_offline_aging_cal";
		public static final String OFFLINE_IMPAIRMENT_CAL_MAPPING = "fjs_offline_impairment_cal_mapping";
		public static final String OFFLINE_RUN = "fjs_offline_run";
		
		public static final String NEWPOST_JOURNALS_TO_ENTRY = "fjs_newpost_journals_to_entry";
		public static final String NEWPOST_ENTRY_TO_TRANSVOLUMN = "fjs_newpost_entry_to_transvolumn";
		
		public static final String DAILY_CLOSING_JAVA = "fjs_daily_closing_java";
		public static final String DUNDLE_XC = "fjs_bundle_xc";
		public static final String MDB2DB_TS = "fjs_mdb2db_ts";

		public static final String UNBILLED_RUN = "fjs_unbilled_run";
		
		public static final String UNBILLED_RC_MANAGE_UNBILLEDREPORT = "fjs_unbilled_rc_report";//这个是从unbilledrc中拆分出来的report不是原先的ubilled_report
		public static final String UNBILLED_RC_MANAGE_RCFROMUPC = "fjs_unbilled_rc_from_upc";
		public static final String UNBILLED_RC_MANAGE_RCFROMFJUNBILLEDREV = "fjs_unbilled_rc_from_rev";
		public static final String UNBILLED_RC_UNBILLEDRC = "fjs_unbilled_rc_java"; //这个已经废弃但是在AM中暂时有配置
		public static final String UNBILLED_RC_UNBILLEDREPORT = "fjs_unbilled_unbilled_report"; //这个应该已经废弃了在AM中没有配置，流程名字自己添加的
		
		public static final String UNBILLED_REVENUE_JAVA = "fjs_unbilled_revenue_java";	
		public static final String UNBILLED_DISCOUNT = "fjs_unbilled_discount";
		public static final String UNBILLED_OTCUSAGE_JAVA = "fjs_unbilled_otcusage_java";
		
		public static final String CANCLE_INVOICE = "fjs_cancle_invoice";
		public static final String PERIODIZATION = "Periodization";
		public static final String EDI_DT = "fjs_edi_dt";
		public static final String EDI_POSTING = "fjs_edi_posting";
		public static final String REPORTSUMMARY = "fjs_reportSummary";
		public static final String DUNNINGFEE = "fjs_DunningFee";
		public static final String MONTHLY_CLOSTING = "fjs_monthly_closing";
		public static final String BILLED_RECONCILIATION = "fjs_billed_reconciliation";
		public static final String WHOSALEINV_JAVA = "fjs_whosaleInv_java";
		
	}
	
	public static final class InvoiceListType{
		private InvoiceListType() {
		}
		public static final String INV_LIST = "inv_list";
		public static final String TAX_INV_LIST = "tax_inv_list";
	}
	
    public static final class RegionCode{
        private RegionCode() {
        }

        public static final int REGIONCODE_HZ = 571;    //杭州
        public static final int REGIONCODE_HUZ = 572;   //湖州
        public static final int REGIONCODE_JX = 573;    //嘉兴
        public static final int REGIONCODE_JH = 579;    //金华
        public static final int REGIONCODE_LS = 578;    //丽水
        public static final int REGIONCODE_NB = 574;    //宁波
        public static final int REGIONCODE_QZ = 570;    //衢州
        public static final int REGIONCODE_SX = 575;    //绍兴
        public static final int REGIONCODE_TZ = 576;    //台州
        public static final int REGIONCODE_WZ = 577;    //温州
        public static final int REGIONCODE_ZS = 580;    //舟山
        
        
    }
    
    public static final class StarLevel{
    	public static final int STARLEVER_UNRATED = -1; //未评级
    	public static final int STARLEVER_PRESTAR = 0; //准星级
    	public static final int STARLEVER_1STAR = 1; //一星级
    	public static final int STARLEVER_2STAR = 2; //二星级
    	public static final int STARLEVER_3STAR = 3; //三星级
    	public static final int STARLEVER_4STAR = 4; //四星级
    	public static final int STARLEVER_5STAR = 5; //五星级
    	public static final int STARLEVER_5STARG = 6; //五星金
    	public static final int STARLEVER_5STARD = 7; //五星钻
    	
    }
    
    /**
	 * 订单接口表中gift sts字段的枚举值
	 */
	public static final class GiftSts {
		private GiftSts() {
		}

		/** 初始状态，未处理状态 */
		public static final Integer NORMAL = 0;
		
		/** 数据处理成功 */
		public static final Integer SUCCESS = 1;
		
		/** 处理失败的数据。比如找不到mapping 规则的数据， */
		public static final Integer FAIL = 2;
		
	}
	
	 /**
		 * 订单接口表中gift flag字段的枚举值
		 */
		public static final class GiftFlag {
			private GiftFlag() {
			}

			/** 初始状态，非赠送 */
			public static final Integer UNGIFT = 0;
			
			/** 赠送 */
			public static final Integer  GIFT= 1;
			
		}
		public static final class ItemCode{
			private  ItemCode() {
			}
			//赠送通信
			public static final Integer GIFT_TERM=1008001;
		    //赠送实物
			public static final Integer GIFT_GOODS=1008002;
			//赠送电子券
			public static final Integer GIFT_ELEC=1008003;
			public static final Integer GIFT_POINT=1008004;
			//新赠送积分
			public static final Integer GIFT_POINT_NEW=1008000;
		}
		//charge_type=1008下的赠送积分价格,1个积分=0.012元
		public static final double GIFT_POINT_RATE = 0.012;
		
		/**
		 * FJS依赖流程的一些字段
		 */
		public static final class ProcedureStart{
			private ProcedureStart() {
			}
			//最大查询次数
			public static final String PRO_MAX_SELECT_NUMBER = "PRO_MAX_SELECT_NUMBER";
			//最大睡眠时间
			public static final String PRO_MAX_SLEEP_TIME = "PRO_MAX_SLEEP_TIME";
			//最大等待时间
			public static final String PRO_MAX_WAIT_TIME = "PRO_MAX_WAIT_TIME";
			//采集未结束
			public static final int COLLECT_STATUS_RUNNING = 1;
			//采集已结束
			public static final int COLLECT_STATUS_FINISHED = 2;
			//终端存量(即月全量)
			public static final String FULL_TERMINAL = "FULL_TERMINAL";
			//终端增量(即日增量)
			public static final String INC_TERMINAL = "INC_TERMINAL";
			//酬金存量(即月全量)
			public static final String FULL_REWARED = "FULL_REWARED";
		}
		
		/**
		 * 套餐列帐的拆分状态
		 */
		public static final class SplitSts{
			private SplitSts(){}
			
			// 月费拆分 - 未规定业务量的量化型
			public static final int MONTH_SPLIT_UFQ = 11;
			// 月费拆分 - 规定业务量的量化型
			public static final int MONTH_SPLIT_FQ = 12;
			// 月费拆分 - default
			public static final int MONTH_SPLIT = 14;
			// 产品包拆分
			public static final int PACKAGE_SPLIT = 2;
			// 包打保底促销拆分
			public static final int PROM_SPLIT = 3;
			// 宽带拆分
			public static final int BB_SPLIT = 4;
			// 模组拆分
			public static final int MODULE_SPLIT = 5;
			// 保底拆分
			public static final int QUARANTEE_SPLIT = 6;
			// 拆分错误
			public static final int SPLIT_ERROR = -1;
			// 拆分初始化
			public static final int SPLIT_INIT = 0;
		}
}
