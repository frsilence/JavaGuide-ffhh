package cn.ffhh.bookstore.service.imp;

@SuppressWarnings("serial")
public class CartException extends Exception {
	public CartException() {
		super();
	}
	public CartException(String message) {
		super(message);
	}
}
