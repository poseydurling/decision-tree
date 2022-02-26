package sol;

public class Edge {

    private ITreeNode leafNode;
    private String attributeValue;

    public Edge(ITreeNode leafNode, String attributeValue){
        this.leafNode = leafNode;
        this.attributeValue = attributeValue;
    }

    public String getValue(){
        return this.attributeValue;
    }

    public ITreeNode getNode(){
        return this.leafNode;
    }
}
