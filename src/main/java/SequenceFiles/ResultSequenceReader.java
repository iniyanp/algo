package SequenceFiles;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.io.SequenceFile.Writer;

import java.util.LinkedList;
import java.util.List;


public class ResultSequenceReader {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        System.out.println("Iniyan");

        Configuration config = new Configuration();
        //first.seq: 307
        //second.seq: 31
//        String hdfsRoot = "hdfs://100.127.6.32:9000";
//        String uri = hdfsRoot+"/data/hub/vehicle/US-MKZ-0002/2018/09/13/02/27/55/lidar/ros/lidarRosVelodyneCombined.seq";
//        Path path = new Path(URI.create(uri));


        Path path = new Path("/Users/iniyan.paramasivam/scale/result.seq");
        SequenceFile.Reader reader = null;
        try {
            reader = new SequenceFile.Reader(FileSystem.get(config), path, config);
            Configuration conf = new Configuration();

            WritableComparable key = (WritableComparable) reader.getKeyClass().newInstance();
            Writable value = (Writable) reader.getValueClass().newInstance();
            int count = 0;

            while (reader.next(key, value)) {
                long keyLong = Long.parseLong(key.toString());
                System.out.println(value.toString());
                count++;
            }
            System.out.println(count);
            reader.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
