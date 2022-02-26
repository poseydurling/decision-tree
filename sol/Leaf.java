package sol;

import src.Row;

public class Leaf implements ITreeNode{

    private String decision;

    public Leaf(String decision){
        this.decision = decision;
    }

    @Override
    public String getDecision(Row forDatum) {
        return this.decision;
    }
}
