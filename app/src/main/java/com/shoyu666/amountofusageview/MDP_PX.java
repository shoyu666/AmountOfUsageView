package com.shoyu666.amountofusageview;



/**
 * Dp Px 工具
 */
public class MDP_PX {
	/**
	 *  将dp转换成px 
	 *  
	 */
	public static int dip2px(float dipValue) {
		float scale =MyApplication.mContext.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}
}
