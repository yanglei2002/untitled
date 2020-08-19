package com.bw.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zxam01 {
    public static void main(String[] args) {

        String str = "HTTP Server（简称Apache）是Apache软件基金会的一个开放源码的网页服务器，可以在大多数计算机操作系统中运行，由于其多平台和安全性被广泛使用，是最流行的Web服务器端软件之一。它快速、可靠并且可通过简单的API扩展，将Perl/Python等解释器编译到服务器中。 [2] "+
                "Apache HTTP服务器是一个模块化的服务器，源于NCSAhttpd服务器，经过多次修改，成为世界使用排名第一的Web服务器软件。"+
                "它可以运行在几乎所有广泛使用的计算机平台上。"+
                "Apache源于NCSAhttpd服务器，经过多次修改，成为世界上最流行的Web服务器软件之一。Apache取自“a patchy server”的读音，意思是充满补丁的服务器，因为它是自由软件，所以不断有人来为它开发新的功能、新的特性、修改原来的缺陷。Apache的特点是简单、速度快、性能稳定，并可做代理服务器来使用。"+
                "本来它只用于小型或试验Internet网络，后来逐步扩充到各种Unix系统中，尤其对Linux的支持相当完美。Apache有多种产品，可以支持SSL技术，支持多个虚拟主机。Apache是以进程为基础的结构，进程要比线程消耗更多的系统开支，不太适合于多处理器环境，因此，在一个Apache Web站点扩容时，通常是增加服务器或扩充群集节点而不是增加处理器。到目前为止Apache仍然是世界上用的最多的Web服务器，市场占有率达60%左右。世界上很多著名的网站如Amazon、Yahoo!、W3 Consortium、Financial Times等都是Apache的产物，它的成功之处主要在于它的源代码开放、有一支开放的开发队伍、支持跨平台的应用（可以运行在几乎所有的Unix、Windows、Linux系统平台上）以及它的可移植性等方面。"+
                "Apache的诞生极富有戏剧性。当NCSAWWW服务器项目停顿后，那些使用NCSAWWW服务器的人们开始交换他们用于该服务器的补丁程序，他们也很快认识到成立管理这些补丁程序的论坛是必要的。就这样，诞生了Apache Group，后来这个团体在NCSA的基础上创建了Apache。";
        String[] split = str.split("");
        //1、自定义一个结构，利用合适的集合类统计字符出现的次数（ 结构定义合理10分，拆分字符10分，统计10分）。
        Map<String,Integer> map = new HashMap<>();

        for(String string:split){
            if(map.get(string)==null){
                map.put(string,1);
            }else{
                map.put(string,map.get(string)+1);
            }
        }
        System.out.println("-------------------------------------");
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String,Integer>entry:entries){
            System.out.println(entry.getKey()+":"+map.get(entry.getKey()));
        }

        System.out.println("-------------------至少使用两种遍历方式打印每个字母出现的次数-------------------");
        System.out.println("-------------------第一种遍历方式 keySet-------------------");
        //2、至少使用两种遍历方式打印每个字母出现的次数（每个遍历方式20分）。
        Set<String> keySet = map.keySet();
        for (String string:keySet){
            if(string.matches("[a-zA-Z]")){
                System.out.println(string+":"+map.get(string));
            }
        }
        System.out.println("-------------------第二种遍历方式entrySet -------------------");
        Set<Map.Entry<String, Integer>> entrySet2 = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet2) {
            if(entry.getKey().matches("[a-zA-Z]")){
                System.out.println(entry.getKey()+" : "+map.get(entry.getKey()));
            }
        }


//		3、统计每个单词出现的次数。然后遍历打印（拆分正确10分，遍历10分，统计结果正确10分）。
        System.out.println("-------------统计每个单词出现的次数。然后遍历打印---------------");
        Map<String,Integer> m = new HashMap<>();

        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = p.matcher(str);
        while(matcher.find()){
            String key = matcher.group();
            if(m.get(key) == null){
                m.put(key, 1);
            }else{
                m.put(key, m.get(key)+1);
            }
        }

        Set<String> keySet2 = m.keySet();
        for (String string : keySet2) {
            System.out.println(string+" : "+m.get(string));
        }
        System.out.println("-------------统计每个单词出现的次数。然后遍历打印--------------->>>");
        HashMap<String, Object> map1 = new HashMap<>();
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher1 = pattern.matcher(str);
        while (matcher1.find()){
            String group = matcher1.group();
            if(map1.get(group)==null){
                map1.put(group,1);
            }else {
                map1.put(group,m.get(group)+1);
            }
        }
        Set<String> keySet3 = m.keySet();
        for (String string : keySet2) {
            System.out.println(string+" : "+m.get(string));
        }
//		4、打印出现次数超过3次的单词（大小写不敏感）（敏感处理10分，3次的判断10分）。
        System.out.println("---------打印出现次数超过3次的单词（大小写不敏感）---------");
        Set<Map.Entry<String, Integer>> entrySet3 = m.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet3) {
            if(entry.getValue()>3){
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
        }
        Set<Map.Entry<String, Integer>> entries1 = m.entrySet();
        for (Map.Entry<String,Integer>entry1:entries1){
            if(entry1.getValue()>3){
                System.out.println(entry1.getKey()+":"+entry1.getValue());
            }
        }
    }
}
