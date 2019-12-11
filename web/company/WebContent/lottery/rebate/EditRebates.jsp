<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <script>var jsver=20191126;</script>
    <script>var isOpenUpper="0";</script>
    <script> if (top.location == self.location) top.location.href = "/"; </script>
    <title>title</title>
    <link href="favicon.ico" rel="shortcut icon">

    <%@ include file="/include/include.inc.jsp" %>

    <%@ include file="/include/include.head.jsp" %>

    <%@ include file="/include/include.js.jsp" %>

    <script>

        var backurl="/account/zd_list.aspx?lid=0";

        var drawBackjson={
            "kl10": {
                "kl10_a_81": "0.85",
                "kl10_b_81": "3.85",
                "kl10_c_81": "2.85",
                "kl10_max_amount_81": "10000",
                "kl10_phase_amount_81": "20000",
                "kl10_single_min_amount_81": "2",
                "kl10_a_82": "0.85",
                "kl10_b_82": "3.85",
                "kl10_c_82": "2.85",
                "kl10_max_amount_82": "20000",
                "kl10_phase_amount_82": "60000",
                "kl10_single_min_amount_82": "2",
                "kl10_a_83": "0.85",
                "kl10_b_83": "3.85",
                "kl10_c_83": "2.85",
                "kl10_max_amount_83": "20000",
                "kl10_phase_amount_83": "60000",
                "kl10_single_min_amount_83": "2",
                "kl10_a_84": "0.85",
                "kl10_b_84": "3.85",
                "kl10_c_84": "2.85",
                "kl10_max_amount_84": "20000",
                "kl10_phase_amount_84": "60000",
                "kl10_single_min_amount_84": "2",
                "kl10_a_85": "0.85",
                "kl10_b_85": "3.85",
                "kl10_c_85": "2.85",
                "kl10_max_amount_85": "20000",
                "kl10_phase_amount_85": "60000",
                "kl10_single_min_amount_85": "2",
                "kl10_a_121": "0.85",
                "kl10_b_121": "3.85",
                "kl10_c_121": "2.85",
                "kl10_max_amount_121": "10000",
                "kl10_phase_amount_121": "20000",
                "kl10_single_min_amount_121": "2",
                "kl10_a_122": "0.85",
                "kl10_b_122": "3.85",
                "kl10_c_122": "2.85",
                "kl10_max_amount_122": "10000",
                "kl10_phase_amount_122": "20000",
                "kl10_single_min_amount_122": "2",
                "kl10_a_11": "0.85",
                "kl10_b_11": "3.85",
                "kl10_c_11": "2.85",
                "kl10_max_amount_11": "20000",
                "kl10_phase_amount_11": "60000",
                "kl10_single_min_amount_11": "2",
                "kl10_a_12": "0.85",
                "kl10_b_12": "3.85",
                "kl10_c_12": "2.85",
                "kl10_max_amount_12": "20000",
                "kl10_phase_amount_12": "60000",
                "kl10_single_min_amount_12": "2",
                "kl10_a_13": "0.85",
                "kl10_b_13": "3.85",
                "kl10_c_13": "2.85",
                "kl10_max_amount_13": "20000",
                "kl10_phase_amount_13": "60000",
                "kl10_single_min_amount_13": "2",
                "kl10_a_72": "0.85",
                "kl10_b_72": "3.85",
                "kl10_c_72": "2.85",
                "kl10_max_amount_72": "2000",
                "kl10_phase_amount_72": "5000",
                "kl10_single_min_amount_72": "2",
                "kl10_a_73": "0.85",
                "kl10_b_73": "3.85",
                "kl10_c_73": "2.85",
                "kl10_max_amount_73": "2000",
                "kl10_phase_amount_73": "5000",
                "kl10_single_min_amount_73": "2",
                "kl10_a_74": "0.85",
                "kl10_b_74": "3.85",
                "kl10_c_74": "2.85",
                "kl10_max_amount_74": "2000",
                "kl10_phase_amount_74": "5000",
                "kl10_single_min_amount_74": "2",
                "kl10_a_75": "0.85",
                "kl10_b_75": "3.85",
                "kl10_c_75": "2.85",
                "kl10_max_amount_75": "2000",
                "kl10_phase_amount_75": "5000",
                "kl10_single_min_amount_75": "2",
                "kl10_a_76": "0.85",
                "kl10_b_76": "3.85",
                "kl10_c_76": "2.85",
                "kl10_max_amount_76": "2000",
                "kl10_phase_amount_76": "5000",
                "kl10_single_min_amount_76": "2",
                "kl10_a_77": "0.85",
                "kl10_b_77": "3.85",
                "kl10_c_77": "2.85",
                "kl10_max_amount_77": "2000",
                "kl10_phase_amount_77": "5000",
                "kl10_single_min_amount_77": "2",
                "kl10_a_78": "0.85",
                "kl10_b_78": "3.85",
                "kl10_c_78": "2.85",
                "kl10_max_amount_78": "1000",
                "kl10_phase_amount_78": "3000",
                "kl10_single_min_amount_78": "2",
                "kl10_a_79": "0.85",
                "kl10_b_79": "3.85",
                "kl10_c_79": "2.85",
                "kl10_max_amount_79": "1000",
                "kl10_phase_amount_79": "3000",
                "kl10_single_min_amount_79": "2",
                "kl10_a_80": "0.85",
                "kl10_b_80": "3.85",
                "kl10_c_80": "2.85",
                "kl10_max_amount_80": "20000",
                "kl10_phase_amount_80": "60000",
                "kl10_single_min_amount_80": "2"
            },
            "cqsc": {
                "cqsc_a_1": "0.85",
                "cqsc_b_1": "3.85",
                "cqsc_c_1": "2.85",
                "cqsc_max_amount_1": "10000",
                "cqsc_phase_amount_1": "30000",
                "cqsc_single_min_amount_1": "2",
                "cqsc_a_2": "0.85",
                "cqsc_b_2": "3.85",
                "cqsc_c_2": "2.85",
                "cqsc_max_amount_2": "20000",
                "cqsc_phase_amount_2": "60000",
                "cqsc_single_min_amount_2": "2",
                "cqsc_a_3": "0.85",
                "cqsc_b_3": "3.85",
                "cqsc_c_3": "2.85",
                "cqsc_max_amount_3": "20000",
                "cqsc_phase_amount_3": "60000",
                "cqsc_single_min_amount_3": "2",
                "cqsc_a_16": "0.85",
                "cqsc_b_16": "3.85",
                "cqsc_c_16": "2.85",
                "cqsc_max_amount_16": "20000",
                "cqsc_phase_amount_16": "60000",
                "cqsc_single_min_amount_16": "2",
                "cqsc_a_17": "0.85",
                "cqsc_b_17": "3.85",
                "cqsc_c_17": "2.85",
                "cqsc_max_amount_17": "20000",
                "cqsc_phase_amount_17": "60000",
                "cqsc_single_min_amount_17": "2",
                "cqsc_a_18": "0.85",
                "cqsc_b_18": "3.85",
                "cqsc_c_18": "2.85",
                "cqsc_max_amount_18": "20000",
                "cqsc_phase_amount_18": "60000",
                "cqsc_single_min_amount_18": "2",
                "cqsc_a_19": "0.85",
                "cqsc_b_19": "3.85",
                "cqsc_c_19": "2.85",
                "cqsc_max_amount_19": "5000",
                "cqsc_phase_amount_19": "10000",
                "cqsc_single_min_amount_19": "2",
                "cqsc_a_20": "0.85",
                "cqsc_b_20": "3.85",
                "cqsc_c_20": "2.85",
                "cqsc_max_amount_20": "5000",
                "cqsc_phase_amount_20": "10000",
                "cqsc_single_min_amount_20": "2",
                "cqsc_a_21": "0.85",
                "cqsc_b_21": "3.85",
                "cqsc_c_21": "2.85",
                "cqsc_max_amount_21": "5000",
                "cqsc_phase_amount_21": "10000",
                "cqsc_single_min_amount_21": "2"
            },
            "pk10": {
                "pk10_a_1": "0.85",
                "pk10_b_1": "3.85",
                "pk10_c_1": "2.85",
                "pk10_max_amount_1": "10000",
                "pk10_phase_amount_1": "30000",
                "pk10_single_min_amount_1": "2",
                "pk10_a_2": "0.85",
                "pk10_b_2": "3.85",
                "pk10_c_2": "2.85",
                "pk10_max_amount_2": "20000",
                "pk10_phase_amount_2": "60000",
                "pk10_single_min_amount_2": "2",
                "pk10_a_3": "0.85",
                "pk10_b_3": "3.85",
                "pk10_c_3": "2.85",
                "pk10_max_amount_3": "20000",
                "pk10_phase_amount_3": "60000",
                "pk10_single_min_amount_3": "2",
                "pk10_a_4": "0.85",
                "pk10_b_4": "3.85",
                "pk10_c_4": "2.85",
                "pk10_max_amount_4": "20000",
                "pk10_phase_amount_4": "60000",
                "pk10_single_min_amount_4": "2",
                "pk10_a_36": "0.85",
                "pk10_b_36": "3.85",
                "pk10_c_36": "2.85",
                "pk10_max_amount_36": "10000",
                "pk10_phase_amount_36": "20000",
                "pk10_single_min_amount_36": "2",
                "pk10_a_37": "0.85",
                "pk10_b_37": "3.85",
                "pk10_c_37": "2.85",
                "pk10_max_amount_37": "20000",
                "pk10_phase_amount_37": "60000",
                "pk10_single_min_amount_37": "2",
                "pk10_a_38": "0.85",
                "pk10_b_38": "3.85",
                "pk10_c_38": "2.85",
                "pk10_max_amount_38": "20000",
                "pk10_phase_amount_38": "60000",
                "pk10_single_min_amount_38": "2"
            },
            "k8sc": {
                "k8sc_a_1": "0.85",
                "k8sc_b_1": "3.85",
                "k8sc_c_1": "2.85",
                "k8sc_max_amount_1": "10000",
                "k8sc_phase_amount_1": "20000",
                "k8sc_single_min_amount_1": "2",
                "k8sc_a_2": "0.85",
                "k8sc_b_2": "3.85",
                "k8sc_c_2": "2.85",
                "k8sc_max_amount_2": "10000",
                "k8sc_phase_amount_2": "30000",
                "k8sc_single_min_amount_2": "2",
                "k8sc_a_3": "0.85",
                "k8sc_b_3": "3.85",
                "k8sc_c_3": "2.85",
                "k8sc_max_amount_3": "10000",
                "k8sc_phase_amount_3": "30000",
                "k8sc_single_min_amount_3": "2",
                "k8sc_a_16": "0.85",
                "k8sc_b_16": "3.85",
                "k8sc_c_16": "2.85",
                "k8sc_max_amount_16": "10000",
                "k8sc_phase_amount_16": "30000",
                "k8sc_single_min_amount_16": "2",
                "k8sc_a_17": "0.85",
                "k8sc_b_17": "3.85",
                "k8sc_c_17": "2.85",
                "k8sc_max_amount_17": "10000",
                "k8sc_phase_amount_17": "30000",
                "k8sc_single_min_amount_17": "2",
                "k8sc_a_18": "0.85",
                "k8sc_b_18": "3.85",
                "k8sc_c_18": "2.85",
                "k8sc_max_amount_18": "10000",
                "k8sc_phase_amount_18": "30000",
                "k8sc_single_min_amount_18": "2",
                "k8sc_a_19": "0.85",
                "k8sc_b_19": "3.85",
                "k8sc_c_19": "2.85",
                "k8sc_max_amount_19": "5000",
                "k8sc_phase_amount_19": "10000",
                "k8sc_single_min_amount_19": "2",
                "k8sc_a_20": "0.85",
                "k8sc_b_20": "3.85",
                "k8sc_c_20": "2.85",
                "k8sc_max_amount_20": "5000",
                "k8sc_phase_amount_20": "10000",
                "k8sc_single_min_amount_20": "2",
                "k8sc_a_21": "0.85",
                "k8sc_b_21": "3.85",
                "k8sc_c_21": "2.85",
                "k8sc_max_amount_21": "5000",
                "k8sc_phase_amount_21": "10000",
                "k8sc_single_min_amount_21": "2"
            },
            "xyft5": {
                "xyft5_a_1": "0.85",
                "xyft5_b_1": "3.85",
                "xyft5_c_1": "2.85",
                "xyft5_max_amount_1": "5000",
                "xyft5_phase_amount_1": "10000",
                "xyft5_single_min_amount_1": "2",
                "xyft5_a_2": "0.85",
                "xyft5_b_2": "3.85",
                "xyft5_c_2": "2.85",
                "xyft5_max_amount_2": "10000",
                "xyft5_phase_amount_2": "20000",
                "xyft5_single_min_amount_2": "2",
                "xyft5_a_3": "0.85",
                "xyft5_b_3": "3.85",
                "xyft5_c_3": "2.85",
                "xyft5_max_amount_3": "10000",
                "xyft5_phase_amount_3": "20000",
                "xyft5_single_min_amount_3": "2",
                "xyft5_a_4": "0.85",
                "xyft5_b_4": "3.85",
                "xyft5_c_4": "2.85",
                "xyft5_max_amount_4": "10000",
                "xyft5_phase_amount_4": "20000",
                "xyft5_single_min_amount_4": "2",
                "xyft5_a_36": "0.85",
                "xyft5_b_36": "3.85",
                "xyft5_c_36": "2.85",
                "xyft5_max_amount_36": "5000",
                "xyft5_phase_amount_36": "10000",
                "xyft5_single_min_amount_36": "2",
                "xyft5_a_37": "0.85",
                "xyft5_b_37": "3.85",
                "xyft5_c_37": "2.85",
                "xyft5_max_amount_37": "10000",
                "xyft5_phase_amount_37": "20000",
                "xyft5_single_min_amount_37": "2",
                "xyft5_a_38": "0.85",
                "xyft5_b_38": "3.85",
                "xyft5_c_38": "2.85",
                "xyft5_max_amount_38": "10000",
                "xyft5_phase_amount_38": "20000",
                "xyft5_single_min_amount_38": "2"
            },
            "jscar": {
                "jscar_a_1": "0.85",
                "jscar_b_1": "3.85",
                "jscar_c_1": "2.85",
                "jscar_max_amount_1": "10000",
                "jscar_phase_amount_1": "20000",
                "jscar_single_min_amount_1": "2",
                "jscar_a_2": "0.85",
                "jscar_b_2": "3.85",
                "jscar_c_2": "2.85",
                "jscar_max_amount_2": "10000",
                "jscar_phase_amount_2": "30000",
                "jscar_single_min_amount_2": "2",
                "jscar_a_3": "0.85",
                "jscar_b_3": "3.85",
                "jscar_c_3": "2.85",
                "jscar_max_amount_3": "10000",
                "jscar_phase_amount_3": "30000",
                "jscar_single_min_amount_3": "2",
                "jscar_a_4": "0.85",
                "jscar_b_4": "3.85",
                "jscar_c_4": "2.85",
                "jscar_max_amount_4": "10000",
                "jscar_phase_amount_4": "30000",
                "jscar_single_min_amount_4": "2",
                "jscar_a_36": "0.85",
                "jscar_b_36": "3.85",
                "jscar_c_36": "2.85",
                "jscar_max_amount_36": "10000",
                "jscar_phase_amount_36": "20000",
                "jscar_single_min_amount_36": "2",
                "jscar_a_37": "0.85",
                "jscar_b_37": "3.85",
                "jscar_c_37": "2.85",
                "jscar_max_amount_37": "10000",
                "jscar_phase_amount_37": "30000",
                "jscar_single_min_amount_37": "2",
                "jscar_a_38": "0.85",
                "jscar_b_38": "3.85",
                "jscar_c_38": "2.85",
                "jscar_max_amount_38": "10000",
                "jscar_phase_amount_38": "30000",
                "jscar_single_min_amount_38": "2"
            },
            "speed5": {
                "speed5_a_1": "0.85",
                "speed5_b_1": "3.85",
                "speed5_c_1": "2.85",
                "speed5_max_amount_1": "10000",
                "speed5_phase_amount_1": "20000",
                "speed5_single_min_amount_1": "2",
                "speed5_a_2": "0.85",
                "speed5_b_2": "3.85",
                "speed5_c_2": "2.85",
                "speed5_max_amount_2": "10000",
                "speed5_phase_amount_2": "30000",
                "speed5_single_min_amount_2": "2",
                "speed5_a_3": "0.85",
                "speed5_b_3": "3.85",
                "speed5_c_3": "2.85",
                "speed5_max_amount_3": "10000",
                "speed5_phase_amount_3": "30000",
                "speed5_single_min_amount_3": "2",
                "speed5_a_16": "0.85",
                "speed5_b_16": "3.85",
                "speed5_c_16": "2.85",
                "speed5_max_amount_16": "10000",
                "speed5_phase_amount_16": "30000",
                "speed5_single_min_amount_16": "2",
                "speed5_a_17": "0.85",
                "speed5_b_17": "3.85",
                "speed5_c_17": "2.85",
                "speed5_max_amount_17": "10000",
                "speed5_phase_amount_17": "30000",
                "speed5_single_min_amount_17": "2",
                "speed5_a_18": "0.85",
                "speed5_b_18": "3.85",
                "speed5_c_18": "2.85",
                "speed5_max_amount_18": "10000",
                "speed5_phase_amount_18": "30000",
                "speed5_single_min_amount_18": "2",
                "speed5_a_19": "0.85",
                "speed5_b_19": "3.85",
                "speed5_c_19": "2.85",
                "speed5_max_amount_19": "5000",
                "speed5_phase_amount_19": "10000",
                "speed5_single_min_amount_19": "2",
                "speed5_a_20": "0.85",
                "speed5_b_20": "3.85",
                "speed5_c_20": "2.85",
                "speed5_max_amount_20": "5000",
                "speed5_phase_amount_20": "10000",
                "speed5_single_min_amount_20": "2",
                "speed5_a_21": "0.85",
                "speed5_b_21": "3.85",
                "speed5_c_21": "2.85",
                "speed5_max_amount_21": "5000",
                "speed5_phase_amount_21": "10000",
                "speed5_single_min_amount_21": "2"
            },
            "jspk10": {
                "jspk10_a_1": "0.85",
                "jspk10_b_1": "3.85",
                "jspk10_c_1": "2.85",
                "jspk10_max_amount_1": "10000",
                "jspk10_phase_amount_1": "20000",
                "jspk10_single_min_amount_1": "2",
                "jspk10_a_2": "0.85",
                "jspk10_b_2": "3.85",
                "jspk10_c_2": "2.85",
                "jspk10_max_amount_2": "10000",
                "jspk10_phase_amount_2": "30000",
                "jspk10_single_min_amount_2": "2",
                "jspk10_a_3": "0.85",
                "jspk10_b_3": "3.85",
                "jspk10_c_3": "2.85",
                "jspk10_max_amount_3": "10000",
                "jspk10_phase_amount_3": "30000",
                "jspk10_single_min_amount_3": "2",
                "jspk10_a_4": "0.85",
                "jspk10_b_4": "3.85",
                "jspk10_c_4": "2.85",
                "jspk10_max_amount_4": "10000",
                "jspk10_phase_amount_4": "30000",
                "jspk10_single_min_amount_4": "2",
                "jspk10_a_36": "0.85",
                "jspk10_b_36": "3.85",
                "jspk10_c_36": "2.85",
                "jspk10_max_amount_36": "10000",
                "jspk10_phase_amount_36": "20000",
                "jspk10_single_min_amount_36": "2",
                "jspk10_a_37": "0.85",
                "jspk10_b_37": "3.85",
                "jspk10_c_37": "2.85",
                "jspk10_max_amount_37": "10000",
                "jspk10_phase_amount_37": "30000",
                "jspk10_single_min_amount_37": "2",
                "jspk10_a_38": "0.85",
                "jspk10_b_38": "3.85",
                "jspk10_c_38": "2.85",
                "jspk10_max_amount_38": "10000",
                "jspk10_phase_amount_38": "30000",
                "jspk10_single_min_amount_38": "2"
            },
            "jscqsc": {
                "jscqsc_a_1": "0.85",
                "jscqsc_b_1": "3.85",
                "jscqsc_c_1": "2.85",
                "jscqsc_max_amount_1": "10000",
                "jscqsc_phase_amount_1": "20000",
                "jscqsc_single_min_amount_1": "2",
                "jscqsc_a_2": "0.85",
                "jscqsc_b_2": "3.85",
                "jscqsc_c_2": "2.85",
                "jscqsc_max_amount_2": "10000",
                "jscqsc_phase_amount_2": "30000",
                "jscqsc_single_min_amount_2": "2",
                "jscqsc_a_3": "0.85",
                "jscqsc_b_3": "3.85",
                "jscqsc_c_3": "2.85",
                "jscqsc_max_amount_3": "10000",
                "jscqsc_phase_amount_3": "30000",
                "jscqsc_single_min_amount_3": "2",
                "jscqsc_a_16": "0.85",
                "jscqsc_b_16": "3.85",
                "jscqsc_c_16": "2.85",
                "jscqsc_max_amount_16": "10000",
                "jscqsc_phase_amount_16": "30000",
                "jscqsc_single_min_amount_16": "2",
                "jscqsc_a_17": "0.85",
                "jscqsc_b_17": "3.85",
                "jscqsc_c_17": "2.85",
                "jscqsc_max_amount_17": "10000",
                "jscqsc_phase_amount_17": "30000",
                "jscqsc_single_min_amount_17": "2",
                "jscqsc_a_18": "0.85",
                "jscqsc_b_18": "3.85",
                "jscqsc_c_18": "2.85",
                "jscqsc_max_amount_18": "10000",
                "jscqsc_phase_amount_18": "30000",
                "jscqsc_single_min_amount_18": "2",
                "jscqsc_a_19": "0.85",
                "jscqsc_b_19": "3.85",
                "jscqsc_c_19": "2.85",
                "jscqsc_max_amount_19": "5000",
                "jscqsc_phase_amount_19": "10000",
                "jscqsc_single_min_amount_19": "2",
                "jscqsc_a_20": "0.85",
                "jscqsc_b_20": "3.85",
                "jscqsc_c_20": "2.85",
                "jscqsc_max_amount_20": "5000",
                "jscqsc_phase_amount_20": "10000",
                "jscqsc_single_min_amount_20": "2",
                "jscqsc_a_21": "0.85",
                "jscqsc_b_21": "3.85",
                "jscqsc_c_21": "2.85",
                "jscqsc_max_amount_21": "5000",
                "jscqsc_phase_amount_21": "10000",
                "jscqsc_single_min_amount_21": "2"
            },
            "happycar": {
                "happycar_a_1": "0.85",
                "happycar_b_1": "3.85",
                "happycar_c_1": "2.85",
                "happycar_max_amount_1": "10000",
                "happycar_phase_amount_1": "20000",
                "happycar_single_min_amount_1": "2",
                "happycar_a_2": "0.85",
                "happycar_b_2": "3.85",
                "happycar_c_2": "2.85",
                "happycar_max_amount_2": "10000",
                "happycar_phase_amount_2": "30000",
                "happycar_single_min_amount_2": "2",
                "happycar_a_3": "0.85",
                "happycar_b_3": "3.85",
                "happycar_c_3": "2.85",
                "happycar_max_amount_3": "10000",
                "happycar_phase_amount_3": "30000",
                "happycar_single_min_amount_3": "2",
                "happycar_a_4": "0.85",
                "happycar_b_4": "3.85",
                "happycar_c_4": "2.85",
                "happycar_max_amount_4": "10000",
                "happycar_phase_amount_4": "30000",
                "happycar_single_min_amount_4": "2",
                "happycar_a_36": "0.85",
                "happycar_b_36": "3.85",
                "happycar_c_36": "2.85",
                "happycar_max_amount_36": "10000",
                "happycar_phase_amount_36": "20000",
                "happycar_single_min_amount_36": "2",
                "happycar_a_37": "0.85",
                "happycar_b_37": "3.85",
                "happycar_c_37": "2.85",
                "happycar_max_amount_37": "10000",
                "happycar_phase_amount_37": "30000",
                "happycar_single_min_amount_37": "2",
                "happycar_a_38": "0.85",
                "happycar_b_38": "3.85",
                "happycar_c_38": "2.85",
                "happycar_max_amount_38": "10000",
                "happycar_phase_amount_38": "30000",
                "happycar_single_min_amount_38": "2"
            }
        };
        var shortcut_kl10_tm = "81";
        var shortcut_kl10_lmp ="82,83,84,85,121,122,11,12,13,80";
        var shortcut_kl10_lm = "72,73,74,75,76,77,78,79";
        var shortcut_cqsc_tm = "1";
        var shortcut_cqsc_lmp ="2,3,16,17,18,19,20,21";
        var shortcut_pk10_tm = "1";
        var shortcut_pk10_lmp ="2,3,4,37,38,36";
        var shortcut_xync_tm = "81";
        var shortcut_xync_lmp ="82,83,84,85,121,122,11,12,13,80";
        var shortcut_xync_lm = "72,73,74,75,78,79";
        var shortcut_xyft5_tm = "1";
        var shortcut_xyft5_lmp ="2,3,4,37,38,36";
        var shortcut_jscar_tm = "1";
        var shortcut_jscar_lmp ="2,3,4,37,38,36";

        var shortcut_speed5_tm = "1";
        var shortcut_speed5_lmp ="2,3,16,17,18,19,20,21";

        var shortcut_jsk3_lmp ="58,59,60,61,62,63,64";
        var shortcut_kl8_lmp = "65,66,67,68,69,70,71,72";

        var shortcut_k8sc_tm = "1";
        var shortcut_k8sc_lmp ="2,3,16,17,18,19,20,21";

        var shortcut_pcdd_tm = "71001,71006";
        var shortcut_pcdd_lmp ="71002,71003,71004,71005,71007,71008,71013";
        var shortcut_pcdd_lm ="71014";

        var shortcut_pkbjl_lmp ="81001,81002,81003,81004";

        var shortcut_jscqsc_tm = "1";
        var shortcut_jscqsc_lmp ="2,3,16,17,18,19,20,21";
        var shortcut_jspk10_tm = "1";
        var shortcut_jspk10_lmp ="2,3,4,37,38,36";

        var shortcut_jssfc_tm = "81";
        var shortcut_jssfc_lmp ="82,83,84,85,121,122,11,12,13,80";
        var shortcut_jssfc_lm = "72,73,74,75,76,77,78,79";

        var shortcut_jsft2_tm = "1";
        var shortcut_jsft2_lmp ="2,3,4,37,38,36";

        var shortcut_car168_tm = "1";
        var shortcut_car168_lmp ="2,3,4,37,38,36";

        var shortcut_ssc168_tm = "1";
        var shortcut_ssc168_lmp ="2,3,16,17,18,19,20,21";

        var shortcut_vrcar_tm = "1";
        var shortcut_vrcar_lmp ="2,3,4,37,38,36";

        var shortcut_vrssc_tm = "1";
        var shortcut_vrssc_lmp ="2,3,16,17,18,19,20,21";

        var shortcut_xyftoa_tm = "1";
        var shortcut_xyftoa_lmp ="2,3,4,37,38,36";

        var shortcut_xyftsg_tm = "1";
        var shortcut_xyftsg_lmp ="2,3,4,37,38,36";

        var shortcut_happycar_tm = "1";
        var shortcut_happycar_lmp ="2,3,4,37,38,36";

        var shortcut_six_tm = "91001,91002,91006,91007,91008,91057,91009,91010,91015,91021,91022,91025,91026,91027,91028,91029,91039,91052,91053,91054,91055,91056";
        var shortcut_six_lmp = "91003,91004,91005,91011,91012,91013,91014,91023,91024,91038,91041,91042,91043,91044,91045,91046";
        var shortcut_six_lm = "91016,91017,91018,91019,91020,91030,91031,91032,91033,91034,91035,91036,91037,91040,91047,91048,91049,91050,91051,91058,91059,91060,91061,91062,91063,91064,91065";

    </script>
    <style>
        body{ width:100%;}
    </style>
</head>
<body>


<input name="search.hid" value="${command.search.hid}" type="hidden"/>

<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
    <tr>
        <td class="topLeftBg1"></td>
        <td class="topBoxBg1"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="tm2">
            <tr>
                <td width="26" align="center"><div class="topArr"></div></td>
                <td><b>退水設置</b></td>
                <td width="100">&nbsp;</td>
                <td width="140" align="right">

                    <div class="btnIco"><div onclick="javascript:history.go(-1)"><div class="Reico" style="cursor:pointer;">返回</div></div></div>

                </td>
            </tr>
        </table></td>
        <td class="topRightBg1"></td>
    </tr>
    <tr>
        <td class="centerLeftBg"></td>
        <td valign="top" align="center">
            <!--主体部分-->
            <form method="post" id="form_six" name="form_six">
                <div id="drawBackWrap">
                    <table border="0" cellspacing="0" cellpadding="0" width="100%">
                        <tr>
                            <td class="bline" width="80%">
                                <ul>
                                    <li class="tabBtn  w130 disNone" >香港⑥合彩</li>
                                    <li class="tabBtn on w130 " >快彩</li>
                                </ul>
                            </td>
                            <td class="bline" width="20%" align="right">【<b class="green">tttttt6</b>】</td>
                        </tr>
                    </table>
                    <table class="tabBox" id="six" width="100%" border="0" cellspacing="0" cellpadding="0" >

                    </table>
                    <table class="tabBox" id="kc"  width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td>

                                <table class="t_list" style="margin-bottom:3px">
                                    <tbody class="list_hover">
                                    <tr>
                                        <td width="130">退水微調</td>
                                        <td width="150"><em class="addBtns"></em><i class="minBtns"></i><input type="text" value="0.1" id="kc_plwt" class="text zk plNumber w80" /></td>
                                        <td style="text-align:left;padding-left:5px;">在這裏對全局退水進行統壹微調</td>
                                    </tr>
                                    </tbody>
                                </table>

                                <table class="t_list">
                                    <tr>
                                        <th colspan="8">大項快速設置【<b class="red">註意：設置高於上級最高限制時按最高可調</b>】</th>
                                    </tr>
                                    <tr>
                                        <td class="tdbg1">調整項目</td>
                                        <td class="tdbg1" style="">A盤</td>
                                        <td class="tdbg1" style="">B盤</td>
                                        <td class="tdbg1" style="">C盤</td>
                                        <td class="tdbg1">單注限額</td>
                                        <td class="tdbg1">單期限額</td>
                                        <td class="tdbg1">最小單注</td>
                                        <td class="tdbg1">操作</td>
                                    </tr>
                                    <tbody class="list_hover">
                                    <tr style="">
                                        <td>特碼類(第一球、第二球、冠軍 …)</td>
                                        <td  style=""><label class="lBg1"></label>

                                            <input type="text"  name="tm_pk_a" id="tm_pk_a" class="text zk plNumber w80" value="0.85" /></td>
                                        <td  style="">

                                            <input type="text"  name="tm_pk_b" id="tm_pk_b" class="text zk plNumber w80" value="3.85"  /></td>
                                        <td  style="">

                                            <input type="text"  name="tm_pk_c" id="tm_pk_c" class="text zk plNumber w80" value="2.85"  /></td>
                                        <td><input type="text" name="tm_max_amount" id="tm_max_amount" class="text zk onlyNum w80" value="10000"  /></td>
                                        <td><input type="text" name="tm_phase_amount" id="tm_phase_amount" class="text zk onlyNum w80" value="20000"  /></td>
                                        <td><input type="text" name="tm_single_min_amount" id="tm_single_min_amount" class="text zk onlyNum w80" value="2"  /></td>
                                        <td><label class="lBg1"></label><button type="button" name="btnTM" id="btnTM" class="btn" data-class="lBg1">修改</button></td>
                                    </tr>
                                    </tbody>
                                    <tbody class="list_hover">
                                    <tr style="">
                                        <td>兩面類(單雙、大小、龍虎 …)</td>
                                        <td style=""><label class="lBg2"></label>

                                            <input type="text"  name="lmp_pk_a" id="lmp_pk_a" class="text zk plNumber w80"  value="0.85" /></td>
                                        <td style="">

                                            <input type="text"  name="lmp_pk_b" id="lmp_pk_b" class="text zk plNumber w80" value="3.85" /></td>
                                        <td style="">

                                            <input type="text"  name="lmp_pk_c" id="lmp_pk_c" class="text zk plNumber w80" value="2.85" /></td>
                                        <td><input type="text" name="lmp_max_amount" id="lmp_max_amount" class="text zk onlyNum w80" value="10000" /></td>
                                        <td><input type="text" name="lmp_phase_amount" id="lmp_phase_amount" class="text zk onlyNum w80" value="30000" /></td>
                                        <td><input type="text" name="lmp_single_min_amount" id="lmp_single_min_amount" class="text zk onlyNum w80" value="2"  /></td>
                                        <td><label class="lBg2"></label><button type="button" name="btnLMP" id="btnLMP" class="btn" data-class="lBg2">修改</button></td>
                                    </tr>
                                    </tbody>
                                    <tbody class="list_hover">
                                    <tr style="">
                                        <td>連碼類(任選二、任選三 …)</td>
                                        <td style=""><label class="lBg3"></label>

                                            <input type="text"  name="lm_pk_a" id="lm_pk_a" class="text zk plNumber w80"  value="0.85" /></td>
                                        <td style="">

                                            <input type="text"  name="lm_pk_b" id="lm_pk_b" class="text zk plNumber w80" value="3.85" /></td>
                                        <td style="">

                                            <input type="text"  name="lm_pk_c" id="lm_pk_c" class="text zk plNumber w80" value="2.85" /></td>
                                        <td><input type="text" name="lm_max_amount" id="lm_max_amount" class="text zk onlyNum w80" value="2000" /></td>
                                        <td><input type="text" name="lm_phase_amount" id="lm_phase_amount" class="text zk onlyNum w80" value="5000" /></td>

                                        <td><input type="text" name="lm_single_min_amount" id="lm_single_min_amount" class="text zk onlyNum w80" value="2"  /></td>

                                        <td><label class="lBg3"></label><button type="button" name="btnLM" id="btnLM" class="btn" data-class="lBg3">修改</button></td>
                                    </tr>
                                    </tbody>
                                </table>

                                <c:forEach var="map" items="${command.rebatesMap}">
                                <table class="t_list tm3">
                                    <tr>
                                        <th>${views.page["LotteryCode.".concat(map.key)]}</th>
                                    </tr>
                                </table>
                                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="mt3">
                                    <tr>
                                        <td valign="top">
                                            <table class="t_list tm3">
                                                <tbody>
                                                <tr>
                                                    <td class="tdbg1" width="130">交易類型</td>
                                                    <td class="tdbg1" width="130" style="">A盤</td>
                                                    <td class="tdbg1" width="130" style="">B盤</td>
                                                    <td class="tdbg1" width="130" style="">C盤</td>
                                                    <td class="tdbg1" width="130">單注限額</td>
                                                    <td class="tdbg1" width="130">單期限額</td>
                                                    <td class="tdbg1" width="130">最小單注</td>
                                                </tr>
                                                </tbody>

                                                <c:set var="ind"><fmt:formatNumber value="${(map.value.size()/2) + ((map.value.size()%2)>0?1:0)}"></fmt:formatNumber></c:set>
                                                <c:forEach var="map1" items="${map.value}" begin="0" end="${ind - 1}" varStatus="i">
                                                    <tbody class="list_hover">
                                                    <tr>
                                                        <td class="tdbg1">
                                                            <label class="${map1.value.pageType == 'd'?'lBg1':map1.value.pageType == 'lmp'?'lBg2':'lBg3'}"></label>${map1.key}
                                                            <span hidden name="code" >${map1.value.code}</span>
                                                            <span hidden name="betSort" >${map1.value.betSort}</span>
                                                        </td>
                                                        <td style=""><input type="text"  class="text plNumber w80" id="${map1.value.code}_a_81" name="${map1.value.code}_a_81" data-val="${map1.value.rebateA}" value="${map1.value.rebateA}" data-max="${map1.value.parendRebate.rebateA}" /></td>
                                                        <td style=""><input type="text"  class="text plNumber w80" id="${map1.value.code}_b_81" name="${map1.value.code}_b_81" data-val="${map1.value.rebateB}" value="${map1.value.rebateB}" data-max=${map1.value.parendRebate.rebateB} /></td>
                                                        <td style=""><input type="text"  class="text plNumber w80" id="${map1.value.code}_c_81" name="${map1.value.code}_c_81" data-val="${map1.value.rebateC}" value="${map1.value.rebateC}" data-max=${map1.value.parendRebate.rebateC} /></td>
                                                        <td><input type="text" class="text onlyNum w80" id="${map1.value.code}_max_amount_81" name="${map1.value.code}_max_amount_81" data-val="${map1.value.maxBet}" value="${map1.value.maxBet}" data-max=${map1.value.parendRebate.maxBet} /></td>
                                                        <td><input type="text" class="text onlyNum w80" id="${map1.value.code}_phase_amount_81" name="${map1.value.code}_phase_amount_81" data-val="${map1.value.maxExpectBet}" value="${map1.value.maxExpectBet}" data-max=${map1.value.parendRebate.maxExpectBet} /></td>
                                                        <td><input type="text" class="text onlyNum w80" id="${map1.value.code}_single_min_amount_81" name="${map1.value.code}_single_min_amount_81" data-val="${map1.value.minBet}" value="${map1.value.minBet}" data-max=${map1.value.parendRebate.minBet} /></td>

                                                    </tr>
                                                    </tbody>
                                                </c:forEach>






                                            </table>
                                        </td>
                                        <td width="3"></td>
                                        <td valign="top">
                                            <table class="t_list tm3">
                                                <tbody>
                                                    <tr>
                                                        <td class="tdbg1" width="130">交易類型</td>
                                                        <td class="tdbg1" width="130" style="">A盤</td>
                                                        <td class="tdbg1" width="130" style="">B盤</td>
                                                        <td class="tdbg1" width="130" style="">C盤</td>
                                                        <td class="tdbg1" width="130">單注限額</td>
                                                        <td class="tdbg1" width="130">單期限額</td>
                                                        <td class="tdbg1" width="130">最小單注</td>
                                                    </tr>
                                                </tbody>
                                                <c:set var="ind"><fmt:formatNumber value="${(map.value.size()/2) + ((map.value.size()%2)>0?1:0)}"></fmt:formatNumber></c:set>
                                                <c:forEach var="map1" items="${map.value}" begin="${ind}" end="${map.value.size()}">
                                                    <tbody class="list_hover">
                                                    <tr>
                                                        <td class="tdbg1">
                                                            <label class="${map1.value.pageType == 'd'?'lBg1':map1.value.pageType == 'lmp'?'lBg2':'lBg3'}"></label>${map1.key}
                                                            <span hidden name="code" >${map1.value.code}</span>
                                                            <span hidden name="betSort" >${map1.value.betSort}</span>
                                                        </td>
                                                        <td style=""><input type="text"  class="text plNumber w80" id="${map1.value.code}_a_81" name="${map1.value.code}_a_81" data-val="${map1.value.rebateA}" value="${map1.value.rebateA}" data-max="${map1.value.parendRebate.rebateA}" /></td>
                                                        <td style=""><input type="text"  class="text plNumber w80" id="${map1.value.code}_b_81" name="${map1.value.code}_b_81" data-val="${map1.value.rebateB}" value="${map1.value.rebateB}" data-max=${map1.value.parendRebate.rebateB} /></td>
                                                        <td style=""><input type="text"  class="text plNumber w80" id="${map1.value.code}_c_81" name="${map1.value.code}_c_81" data-val="${map1.value.rebateC}" value="${map1.value.rebateC}" data-max=${map1.value.parendRebate.rebateC} /></td>
                                                        <td><input type="text" class="text onlyNum w80" id="${map1.value.code}_max_amount_81" name="${map1.value.code}_max_amount_81" data-val="${map1.value.maxBet}" value="${map1.value.maxBet}" data-max=${map1.value.parendRebate.maxBet} /></td>
                                                        <td><input type="text" class="text onlyNum w80" id="${map1.value.code}_phase_amount_81" name="${map1.value.code}_phase_amount_81" data-val="${map1.value.maxExpectBet}" value="${map1.value.maxExpectBet}" data-max=${map1.value.parendRebate.maxExpectBet} /></td>
                                                        <td><input type="text" class="text onlyNum w80" id="${map1.value.code}_single_min_amount_81" name="${map1.value.code}_single_min_amount_81" data-val="${map1.value.minBet}" value="${map1.value.minBet}" data-max=${map1.value.parendRebate.minBet} /></td>
                                                    </tr>
                                                </tbody>
                                                </c:forEach>

                                            </table>
                                        </td>
                                    </tr>
                                </table>
                                </c:forEach>
                                <!--欢乐赛车 end-->

                            </td>
                        </tr>
                    </table>
                </div>

                <!--主体结束-->
        </td>
        <td class="centerRightBg"></td>
    </tr>
    <tr>
        <td class="bottomLeftBg"></td>
        <td class="bottomBoxBg" align="center"><button type="button" name="backBtn" id="backBtn" class="btn" onclick="javascript:history.go(-1)"> 返回 </button>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" name="Submit" id="drawbackBtn" class="btn">保存</button>&nbsp;&nbsp;&nbsp;&nbsp;

            <input type="hidden" id="hdnSubmit" name="hdnSubmit" value="hdnsubmit" /><input type="hidden" id="uid" name="uid" value="95a1f34f-e689-4cb1-a791-29e62561268a" />
            <input type="hidden" name="isAdd" id="isAdd" value=""  />
            <input type="hidden" name="hdnUType" id="hdnUType" value="zd"  />

        </td>
        <td class="bottomRightBg"></td>
    </tr>
</table></form>

<script type="text/javascript">
    window.onload = function () {
        seajs.use(['jquery', 'drawback', 'tabEvent', 'listHover'], function ($, a, b) {

            b(window.top.masterFirst);

            if ($("#isAdd").val() == '1') {
                top.NewIsAdd = true;
            }else{
                top.NewIsAdd = false;
            }

            // 快彩
//            $("#btnLM").click(function () {
//                selectLM();
//            });
            $("#btnTM,#btnLM,#btnLMP").click(function () {
                $(".text").removeClass('textOn');
                var cla = $(this).attr('data-class');
                var val0 = $(this).parent().parent().find('input').eq(0).val();
                var val1 = $(this).parent().parent().find('input').eq(1).val();
                var val2 = $(this).parent().parent().find('input').eq(2).val();
                var val3 = $(this).parent().parent().find('input').eq(3).val();
                var val4 = $(this).parent().parent().find('input').eq(4).val();
                var val5 = $(this).parent().parent().find('input').eq(5).val();

                $('.'+cla).parent().parent().find('input').eq(0)

                $('.tm3 .'+cla).each(function () {
                    $(this).parent().parent().find('input').addClass("textOn");
                    $(this).parent().parent().find('input').eq(0).val(val0);
                    $(this).parent().parent().find('input').eq(1).val(val1);
                    $(this).parent().parent().find('input').eq(2).val(val2);
                    $(this).parent().parent().find('input').eq(3).val(val3);
                    $(this).parent().parent().find('input').eq(4).val(val4);
                    $(this).parent().parent().find('input').eq(5).val(val5);
                });
//                selectTM();
            });
//            $("#btnLMP").click(function () {
//                selectLMP();
//            });

            // 封装方法
            function setDrawBackInput (spl, type, lottery) {

                var pk_a_val = $("#"+ type +"_pk_a").val();
                var pk_b_val = $("#"+ type +"_pk_b").val();
                var pk_c_val = $("#"+ type +"_pk_c").val();
                var max_amount_val = $("#"+ type +"_max_amount").val();
                var phase_amount_val = $("#"+ type +"_phase_amount").val();
                var single_min_amount_val = $("#"+ type +"_single_min_amount").val();

                var g_type_pk_a = '';
                var g_type_pk_b = '';
                var g_type_pk_c = '';
                var g_type_max_amount = '';
                var g_type_phase_amount = '';
                var g_type_single_min_amount = '';
                var a = '';
                var b = '';
                var c = '';
                var max_amount = '';
                var phase_amount = '';
                var min_amount = '';

                for (var i = 0; i < spl.length; i++) {
                    g_type_pk_a = pk_a_val;
                    g_type_pk_b = pk_b_val;
                    g_type_pk_c = pk_c_val;
                    g_type_max_amount = max_amount_val;
                    g_type_phase_amount = phase_amount_val;
                    g_type_single_min_amount = single_min_amount_val;
                    a = drawBackjson[lottery][lottery + "_a_" + spl[i]];
                    b = drawBackjson[lottery][lottery + "_b_" + spl[i]];
                    c = drawBackjson[lottery][lottery + "_c_" + spl[i]];
                    max_amount = drawBackjson[lottery][lottery + "_max_amount_" + spl[i]];
                    phase_amount = drawBackjson[lottery][lottery + "_phase_amount_" + spl[i]];
                    min_amount = drawBackjson[lottery][lottery + "_single_min_amount_" + spl[i]];

                    if(Number(g_type_pk_a)> Number(a)){
                        g_type_pk_a = a;
                    }
                    if(Number(g_type_pk_b)> Number(b)){
                        g_type_pk_b = b;
                    }
                    if(Number(g_type_pk_c)> Number(c)){
                        g_type_pk_c = c;
                    }
                    if(Number(g_type_max_amount)> Number(max_amount)){
                        g_type_max_amount = max_amount;
                    }
                    if(Number(g_type_phase_amount)> Number(phase_amount)){
                        g_type_phase_amount = phase_amount;
                    }
                    if (Number(g_type_single_min_amount) < Number(min_amount)) {
                        g_type_single_min_amount = min_amount;
                    }

                    $("#"+ lottery +"_a_"+spl[i]).val(g_type_pk_a);
                    $("#"+ lottery +"_b_"+spl[i]).val(g_type_pk_b);
                    $("#"+ lottery +"_c_"+spl[i]).val(g_type_pk_c);
                    $("#"+ lottery +"_max_amount_"+spl[i]).val(g_type_max_amount);
                    $("#"+ lottery +"_phase_amount_"+spl[i]).val(g_type_phase_amount);
                    $("#"+ lottery +"_single_min_amount_"+spl[i]).val(g_type_single_min_amount);
                    $("#"+ lottery +"_a_"+spl[i]).addClass('textOn');
                    $("#"+ lottery +"_b_"+spl[i]).addClass('textOn');
                    $("#"+ lottery +"_c_"+spl[i]).addClass('textOn');
                    $("#"+ lottery +"_max_amount_"+spl[i]).addClass('textOn');
                    $("#"+ lottery +"_phase_amount_"+spl[i]).addClass('textOn');
                    $("#"+ lottery +"_single_min_amount_"+spl[i]).addClass('textOn');
                };
            }

            // green
            function selectLM(){
                $(".text").removeClass('textOn');
                if('y'!=''){
                    var spl=shortcut_kl10_lm.split(",");
                    setDrawBackInput(spl, 'lm', 'kl10');
                }
                if(''!=''){
                    var spl=shortcut_xync_lm.split(",");
                    setDrawBackInput(spl, 'lm', 'xync');
                }
                if ('' != '') {
                    var spl = shortcut_pcdd_lm.split(",");
                    setDrawBackInput(spl, 'lm', 'pcdd');
                }
                if(''!=''){
                    var spl=shortcut_jssfc_lm.split(",");
                    setDrawBackInput(spl, 'lm', 'jssfc');
                }
            }
            // blue
            function selectTM(){
                $(".text").removeClass('textOn');
                if('y'!=''){
                    var spl=shortcut_kl10_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'kl10');
                }
                if('y'!=''){
                    var spl=shortcut_cqsc_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'cqsc');
                }
                if('y'!=''){
                    var spl=shortcut_pk10_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'pk10');
                }
                if(''!=''){
                    var spl=shortcut_xync_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'xync');
                }
                if ('y' != '') {
                    var spl = shortcut_k8sc_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'k8sc');
                }
                if ('' != '') {
                    var spl = shortcut_pcdd_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'pcdd');
                }
                if('y'!=''){
                    var spl=shortcut_xyft5_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'xyft5');
                }
                if('y'!=''){
                    var spl=shortcut_jscar_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'jscar');
                }
                if('y'!=''){
                    var spl=shortcut_speed5_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'speed5');
                }

                if('y'!=''){
                    var spl=shortcut_jscqsc_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'jscqsc');
                }
                if('y'!=''){
                    var spl=shortcut_jspk10_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'jspk10');
                }

                if(''!=''){
                    var spl=shortcut_jssfc_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'jssfc');
                }

                if(''!=''){
                    var spl=shortcut_jsft2_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'jsft2');
                }
                if(''!=''){
                    var spl=shortcut_car168_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'car168');
                }
                if(''!=''){
                    var spl=shortcut_ssc168_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'ssc168');
                }
                if(''!=''){
                    var spl=shortcut_vrcar_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'vrcar');
                }

                if(''!=''){
                    var spl=shortcut_vrssc_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'vrssc');
                }
                if(''!=''){
                    var spl=shortcut_xyftoa_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'xyftoa');
                }
                if(''!=''){
                    var spl=shortcut_xyftsg_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'xyftsg');
                }
                if('y'!=''){
                    var spl=shortcut_happycar_tm.split(",");
                    setDrawBackInput(spl, 'tm', 'happycar');
                }
            }
            // zi
            function selectLMP(){
                $(".text").removeClass('textOn');
                if('y'!=''){
                    var spl=shortcut_kl10_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'kl10');
                }
                if('y'!=''){
                    var spl=shortcut_cqsc_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'cqsc');
                }
                if('y'!=''){
                    var spl=shortcut_pk10_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'pk10');
                }
                if(''!=''){
                    var spl=shortcut_xync_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'xync');
                }
                if(''!=''){
                    var spl=shortcut_jsk3_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'jsk3');
                }
                if(''!=''){
                    var spl=shortcut_kl8_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'kl8');
                }
                if ('y' != '') {
                    var spl = shortcut_k8sc_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'k8sc');
                }
                if ('' != '') {
                    var spl = shortcut_pcdd_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'pcdd');
                }
                if('y'!=''){
                    var spl=shortcut_xyft5_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'xyft5');
                }
                if(''!=''){
                    var spl=shortcut_pkbjl_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'pkbjl');
                }
                if('y'!=''){
                    var spl=shortcut_jscar_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'jscar');
                }
                if('y'!=''){
                    var spl=shortcut_speed5_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'speed5');
                }

                if(''!=''){
                    var spl=shortcut_jssfc_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'jssfc');
                }
                if('y'!=''){
                    var spl=shortcut_jscqsc_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'jscqsc');
                }
                if('y'!=''){
                    var spl=shortcut_jspk10_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'jspk10');
                }

                if(''!=''){
                    var spl=shortcut_jsft2_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'jsft2');
                }
                if(''!=''){
                    var spl=shortcut_car168_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'car168');
                }
                if(''!=''){
                    var spl=shortcut_ssc168_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'ssc168');
                }
                if(''!=''){
                    var spl=shortcut_vrcar_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'vrcar');
                }
                if(''!=''){
                    var spl=shortcut_vrssc_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'vrssc');
                }
                if(''!=''){
                    var spl=shortcut_xyftoa_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'xyftoa');
                }
                if(''!=''){
                    var spl=shortcut_xyftsg_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'xyftsg');
                }
                if('y'!=''){
                    var spl=shortcut_happycar_lmp.split(",");
                    setDrawBackInput(spl, 'lmp', 'happycar');
                }
            }

            // 六合彩
            $("#six_btnTM").click(function () {
                six_btnTM();
            });
            $("#six_btnLMP").click(function () {
                six_btnLMP();
            });
            $("#six_btnLM").click(function () {
                six_btnLM();
            });
            // 封装六合彩方法
            function setSixDrawBackInput (spl, type, lottery) {

                var pk_a_val = $("#six_"+ type +"_pk_a").val();
                var pk_b_val = $("#six_"+ type +"_pk_b").val();
                var pk_c_val = $("#six_"+ type +"_pk_c").val();
                var max_amount_val = $("#six_"+ type +"_max_amount").val();
                var phase_amount_val = $("#six_"+ type +"_phase_amount").val();
                var single_min_amount_val = $("#six_"+ type +"_single_min_amount").val();

                var g_type_pk_a = '';
                var g_type_pk_b = '';
                var g_type_pk_c = '';
                var g_type_max_amount = '';
                var g_type_phase_amount = '';
                var g_type_single_min_amount = '';
                var a = '';
                var b = '';
                var c = '';
                var max_amount = '';
                var phase_amount = '';
                var min_amount = '';

                for (var i = 0; i < spl.length; i++) {
                    g_type_pk_a = pk_a_val;
                    g_type_pk_b = pk_b_val;
                    g_type_pk_c = pk_c_val;
                    g_type_max_amount = max_amount_val;
                    g_type_phase_amount = phase_amount_val;
                    g_type_single_min_amount = single_min_amount_val;
                    a = drawBackjson[lottery][lottery + "_a_" + spl[i]];
                    b = drawBackjson[lottery][lottery + "_b_" + spl[i]];
                    c = drawBackjson[lottery][lottery + "_c_" + spl[i]];
                    max_amount = drawBackjson[lottery][lottery + "_max_amount_" + spl[i]];
                    phase_amount = drawBackjson[lottery][lottery + "_phase_amount_" + spl[i]];
                    min_amount = drawBackjson[lottery][lottery + "_single_min_amount_" + spl[i]];

                    if(Number(g_type_pk_a)> Number(a)){
                        g_type_pk_a = a;
                    }
                    if(Number(g_type_pk_b)> Number(b)){
                        g_type_pk_b = b;
                    }
                    if(Number(g_type_pk_c)> Number(c)){
                        g_type_pk_c = c;
                    }
                    if(Number(g_type_max_amount)> Number(max_amount)){
                        g_type_max_amount = max_amount;
                    }
                    if(Number(g_type_phase_amount)> Number(phase_amount)){
                        g_type_phase_amount = phase_amount;
                    }
                    if (Number(g_type_single_min_amount) < Number(min_amount)) {
                        g_type_single_min_amount = min_amount;
                    }

                    $("#"+ lottery +"_a_"+spl[i]).val(g_type_pk_a);
                    $("#"+ lottery +"_b_"+spl[i]).val(g_type_pk_b);
                    $("#"+ lottery +"_c_"+spl[i]).val(g_type_pk_c);
                    $("#"+ lottery +"_max_amount_"+spl[i]).val(g_type_max_amount);
                    $("#"+ lottery +"_phase_amount_"+spl[i]).val(g_type_phase_amount);
                    $("#"+ lottery +"_single_min_amount_"+spl[i]).val(g_type_single_min_amount);
                    $("#"+ lottery +"_a_"+spl[i]).addClass('textOn');
                    $("#"+ lottery +"_b_"+spl[i]).addClass('textOn');
                    $("#"+ lottery +"_c_"+spl[i]).addClass('textOn');
                    $("#"+ lottery +"_max_amount_"+spl[i]).addClass('textOn');
                    $("#"+ lottery +"_phase_amount_"+spl[i]).addClass('textOn');
                    $("#"+ lottery +"_single_min_amount_"+spl[i]).addClass('textOn');
                };
            }

            function six_btnTM() {
                $(".text").removeClass('textOn');
                var spl=shortcut_six_tm.split(",");
                setSixDrawBackInput(spl, 'tm', 'six');
            }
            function six_btnLMP() {
                $(".text").removeClass('textOn');
                var spl=shortcut_six_lmp.split(",");
                setSixDrawBackInput(spl, 'lmp', 'six');
            }
            function six_btnLM() {
                $(".text").removeClass('textOn');
                var spl=shortcut_six_lm.split(",");
                setSixDrawBackInput(spl, 'lm', 'six');
            }

            $('.text').blur(function () {
                $(this).removeClass('textOn');
            });
        });
    }
</script>
<div id="alert_show"></div>
</body>
</html>