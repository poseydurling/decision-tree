package sol;

import src.ITreeGenerator;
import src.Row;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements the ITreeGenerator interface
 * used to generate a tree
 */
public class TreeGenerator implements ITreeGenerator<Dataset> {

    public TreeGenerator(){
        //this.generateTree();
    }

    @Override
    public void generateTree(Dataset trainingData, String targetAttribute) {
        this.generateTreeHelper(trainingData);
    }

    public ITreeNode generateTreeHelper(Dataset trainingData){
        String splitAttribute = trainingData.randomTargetAttribute();
        if(trainingData.sameValue(splitAttribute)){
            return new Leaf(splitAttribute);
        } else{
            List<Edge> edgeList = new ArrayList<>();
            trainingData.partition(splitAttribute);
            for(Dataset data : trainingData.partition(splitAttribute)){
                edgeList.add(new Edge(this.generateTreeHelper(data), data.getValue(splitAttribute)));
            }
            return new AttributeNode(splitAttribute, edgeList, trainingData.getDefault(splitAttribute));
        }
    }

    @Override
    public String getDecision(Row datum) {
        return null;
    }
    // TODO: Implement methods declared in ITreeGenerator interface!
}
