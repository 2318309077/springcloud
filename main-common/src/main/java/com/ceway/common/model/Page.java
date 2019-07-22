/**  
 * @Title: Page.java
 * @Package com.ceway.bean
 * @Description: TODO
 * @author CW5179 廖志刚
 * @date 2017年4月13日
 */
package com.ceway.common.model;

import java.util.ArrayList;
import java.util.List;

   
/**    
 * ClassName: Page 
 * @Description: 分页工具类
 * @author CW6209 伍金亮
 * @date 2019-6-6
 */
public class Page {
	
	/* 当前页 */
	private int nowPage;
	
	/* 每页大小 */
	private int pageSize;
	
	/* 总共页数 */
	private int totalPage;
	
	/* 总共显示最大页数 */
	private int sideNum;
	
	/* 开始页 */
	private int startPage;
	
	/* 结束页 */
	private int endPage;
	
	/* 总共数据条数 */
	private int totalRecord;
	
	/* 当前页的第一条数据的索引 */
	private int offset;
	
	/* 显示的页码list */
	private List<Integer> pageList;
	
	
	public Page() {
		
	}
	
	public Page(int totalRecord, int nowPage) {
		this(totalRecord, nowPage, 10);
	}
	public Page(int totalRecord, int nowPage,String check) {
		this(totalRecord, nowPage, 15);
	}
	
	/**
	 * 
	 * <p>返回Page对象</p>
	 * @param totalRecord 总共页数	 
	 * @param nowPage  当前页
	 * @param pageSize 每页大小
	 */
	public Page(int totalRecord, int nowPage, int pageSize) {
		this.totalRecord = totalRecord;
		this.nowPage = nowPage;
		
		this.pageSize = pageSize;
		this.sideNum = 5;
		
		//计算当前页第一条数据索引
		this.offset = (nowPage-1)*pageSize;
		
		//计算总页数
		this.totalPage = totalRecord % pageSize == 0 ? totalRecord/pageSize : totalRecord/pageSize + 1;
		
		int middlePage = sideNum/2 + 1;
		if (this.nowPage <= middlePage) {
			//计算开始页
			//1. 当当前页小于等于中间时，开始的页码为1， 
			//    结束的页码有两种情况
			this.startPage = 1;
			if (totalPage <= sideNum) {
				//总页数小于等于规定的页数
				this.endPage = totalPage;
			} else {
				this.endPage = sideNum;
			}
		} else {
			//2. 当前页大于中间页，有四种种情况
			if (totalPage <= sideNum) {
				//总页数仍然小于规定页数，例如：1,2,3,4
				this.startPage = 1;
				this.endPage = totalPage;
			} else if (totalPage-nowPage < middlePage) {
				//例如:   ...2,3,4,5
				this.startPage = totalPage - sideNum + 1;
				this.endPage = totalPage;
			}else if (totalPage > sideNum && middlePage%2==0) {
				//例如：    ...2,3,4,5,6...
				this.startPage = this.nowPage - middlePage + 1;
				this.endPage = this.nowPage + middlePage - 2;
			} else if (totalPage > sideNum && middlePage%2!=0) {
				//例如： ...2,3,4,5,6,7...
				this.startPage = this.nowPage - middlePage + 1;
				this.endPage = this.nowPage + middlePage - 1;
			}
			
		}
		//将页码存入list，供前台显示
		if (totalRecord != 0 && startPage != endPage) {
			pageList = new ArrayList<Integer>();
			for (int i=startPage; i <= endPage; i++) {
				this.pageList.add(i);
			}
		}
	}


	public int getNowPage() {
		return nowPage;
	}


	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getSideNum() {
		return sideNum;
	}


	public void setSideNum(int sideNum) {
		this.sideNum = sideNum;
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getTotalRecord() {
		return totalRecord;
	}


	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}


	public int getOffset() {
		return offset;
	}


	public void setOffset(int offset) {
		this.offset = offset;
	}


	public List<Integer> getPageList() {
		return pageList;
	}


	public void setPageList(List<Integer> pageList) {
		this.pageList = pageList;
	}
	
}
