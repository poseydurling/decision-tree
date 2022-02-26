package sol;

import src.Row;

import java.util.ArrayList;
import java.util.List;

public class AttributeNode implements ITreeNode{

    private String attribute;
    private List<Edge> edge;
    private String mostCommonClassification;

    public AttributeNode(String attribute, ArrayList<Edge> edge, String mostCommonClassification){
        this.attribute = attribute;
        this.edge = new ArrayList<>();
        this.mostCommonClassification = mostCommonClassification;
    }

    @Override
    public String getDecision(Row forDatum) {
        for(Edge outgoingEdge : this.edge){
            if(outgoingEdge.getValue().equals(forDatum.getAttributeValue(this.attribute))){
                return outgoingEdge.getNode().getDecision(forDatum);
            }
        }
        return this.mostCommonClassification;
    }
}