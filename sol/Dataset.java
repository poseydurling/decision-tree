package sol;

import src.IDataset;
import src.Row;

import java.util.List;

/**
 * A class that implements the IDataset interface,
 * representing a training data set.
 */
public class Dataset implements IDataset {
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
}
