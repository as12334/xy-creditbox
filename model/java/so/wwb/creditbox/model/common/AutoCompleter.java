package so.wwb.creditbox.model.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 自动完成填充对象，除了label，其它可自定义增加或修改
 *  {
 *      "id" : 1,
 *      "label" : "显示名称"
 *  }
 * Created by fei on 15-12-1.
 */
public class AutoCompleter {
    private String id;
    private String label;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<AutoCompleter> getCompleters(Map<String, Object> map) {
        if (map.isEmpty())
            return null;
        List<AutoCompleter> completers = new ArrayList<>();
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            AutoCompleter completer = new AutoCompleter();
            completer.setId(entry.getKey().toString());
            completer.setLabel(entry.getValue().toString());
            completers.add(completer);
        }
        return  completers;
    }
}
