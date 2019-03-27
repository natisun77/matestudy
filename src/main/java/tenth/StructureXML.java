package tenth;

import org.apache.log4j.Logger;
import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StructureXML {
    private List<Map<List<Set<Integer>>, String>> list;
    private static final Logger LOGGER = Logger.getLogger(StructureXML.class);

    public StructureXML(int number) {
        list = new ArrayList<>();

        List<Set<Integer>> innerList = new ArrayList<>();
        innerList.add(new HashSet<>(number));

        HashMap<List<Set<Integer>>, String> listStringHashMap = new HashMap<>();
        listStringHashMap.put(innerList, "value");
        list.add(listStringHashMap);
    }

    @Override
    public String toString() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        XMLEncoder e = new XMLEncoder(baos);
        e.writeObject(list);
        e.close();
        return new String(baos.toByteArray());
    }
}
