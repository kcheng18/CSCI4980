/*
 * @(#) GClassNode.java
 *
 */
package graph.model.node;

import graph.model.GNode;

public class GClassNode extends GNode {
	public boolean isPublic;
	
	public GClassNode(String id, String name, boolean isPublic) {
		super(id, name);
		this.isPublic = isPublic;
	}
	
	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}	
}
