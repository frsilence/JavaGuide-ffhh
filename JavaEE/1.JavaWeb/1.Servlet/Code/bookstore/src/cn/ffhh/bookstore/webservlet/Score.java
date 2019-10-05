package cn.ffhh.bookstore.webservlet;

public class Score {
	private Integer high;
	private Integer low;
	private Integer avg;
	
	public Score(Integer high, Integer low, Integer avg) {
		super();
		this.high = high;
		this.low = low;
		this.avg = avg;
	}
	public Integer getHigh() {
		return high;
	}
	public void setHigh(Integer high) {
		this.high = high;
	}
	public Integer getLow() {
		return low;
	}
	public void setLow(Integer low) {
		this.low = low;
	}
	public Integer getAvg() {
		return avg;
	}
	public void setAvg(Integer avg) {
		this.avg = avg;
	}
	
}
