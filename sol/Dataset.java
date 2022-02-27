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
        return 0;
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
