package plug;

import java.io.Serializable;

/**
 * 树节点信息
 * 
 * @author bugerno1
 */
public class TreeInfo implements Serializable {
		/**树节点ID*/
		private String id;
		/**树节点名称*/
		private String text;
		/**图标*/
		private String cls; 
		/**是否叶子*/
		private boolean leaf;
		/**链接*/
		private String href; 
		/**链接指向*/
		private String hrefTarget; 
		/**是否展开*/
		private boolean expandable; 
		/**描述信息*/
		private String description;
		/**树的子节点*/
		//private List<Tree> children;
		/**树的节点序号*/
		private String qtip;
		private int number;
		
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		
		public boolean isLeaf() {
			return leaf;
		}
		public void setLeaf(boolean leaf) {
			this.leaf = leaf;
		}
//		public List<Tree> getChildren() {
//			return children;
//		}
//		public void setChildren(List<Tree> children) {
//			this.children = children;
//		}
		public String getCls() {
			return cls;
		}
		public void setCls(String cls) {
			this.cls = cls;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public boolean isExpandable() {
			return expandable;
		}
		public void setExpandable(boolean expandable) {
			this.expandable = expandable;
		}
		public String getHref() {
			return href;
		}
		public void setHref(String href) {
			this.href = href;
		}
		public String getHrefTarget() {
			return hrefTarget;
		}
		public void setHrefTarget(String hrefTarget) {
			this.hrefTarget = hrefTarget;
		}
		public void setChecked(Boolean checked) {
			
		}
		public String getQtip() {
			return qtip;
		}
		public void setQtip(String qtip) {
			this.qtip = qtip;
		}
}
