package sol;

import src.IDataset;
import src.Row;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements the IDataset interface,
 * representing a training data set.
 */
public class Dataset implements IDataset {
    private List<Row> dataObject;
    private List<String> attributes;
    private int counter;
    private String other;

    public Dataset(List<Row> rowObject, List<String> attributeList) {
        this.dataObject = rowObject;
        this.attributes = attributeList;
    }

    @Override
    public List<String> getAttributeList() {
        return null;
    }

    @Override
    public List<Row> getDataObjects() {
        return null;
    }

    @Override
    public int size() {
        return this.dataObject.size();
    }

    public List<String> getDistinctVal(String attribute) {
        List<String> val = new ArrayList<>();
        for (Row object : this.dataObject) {
            String myString = object.getAttributeValue(attribute);
            if (val.contains(myString) == false) {
                val.add(myString);
            }
        }
        return val;
    }

    public String getValue(String attribute){
        return this.dataObject.get(0).getAttributeValue(attribute);
    }

    public boolean sameValue(String attribute){
        boolean result = true;
        for(Row row : this.dataObject){
            if (this.dataObject.get(0).getAttributeValue(attribute).equals(row.getAttributeValue(attribute))) {
                this.counter++;
            } else{
                result = false;
                this.other = row.getAttributeValue(attribute);
            }
        }
        return result;
    }

    public String randomTargetAttribute(){
        int num = (int)(Math.random()*(this.attributes.size() + 1));
        return this.attributes.get(num);
    }

    public String getDefault(String attribute){
        if(this.counter / 2 > this.size()){
            return this.dataObject.get(0).getAttributeValue(attribute);
        } else{
            return this.other;
        }
    }

    //method that removes string
    private List<String> partitionHelper(List<String> originalList, String targetRemove){
        List<String> newList = new ArrayList<>(originalList);
        newList.remove(targetRemove);
        return newList;
    }

    public List<Dataset> partition(String attribute){
        List<Dataset> subsets = new ArrayList<>();
        List<String> distinctVal = getDistinctVal(attribute);
        List<String> newAttribute = this.partitionHelper(this.attributes, attribute); // passing in Attribute list and
        // the attribute we are splitting on
        for (String eachVal: distinctVal){
            List<Row> individualVal = new ArrayList<>();
            for (Row datum : this.dataObject){
                if (datum.getAttributeValue(attribute).equals(eachVal)){
                    individualVal.add(datum);
                }
            }
            subsets.add(new Dataset(individualVal, newAttribute));
        }
        return subsets;
    }
}
