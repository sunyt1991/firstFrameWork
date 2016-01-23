package plug;

import java.util.Collection;

public class PageData<E> {

	private long total;
	
	private Collection<E> rows;
	
	private Collection<E> footer;
	
	private Object other;

	public Object getOther() {
		return other;
	}

	public void setOther(Object other) {
		this.other = other;
	}

	public Collection<E> getFooter() {
		return footer;
	}

	public void setFooter(Collection<E> footer) {
		this.footer = footer;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public Collection<E> getRows() {
		return rows;
	}

	public void setRows(Collection<E> rows) {
		this.rows = rows;
	}
}
