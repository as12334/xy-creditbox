package so.wwb.lotterybox.common.export.core.conf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mark on 15-8-20:上午11:02.
 */
public class ExportConf {

    private Map<String, ExportItemConf> exportItemConfs = new HashMap<>();

    public Map<String, ExportItemConf> getExportItemConfs() {
        return exportItemConfs;
    }

    public void setExportItemConfs(Map<String, ExportItemConf> exportItemConfs) {
        this.exportItemConfs = exportItemConfs;
    }
}
