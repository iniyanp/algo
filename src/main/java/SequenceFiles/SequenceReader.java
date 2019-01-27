package SequenceFiles;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.io.compress.GzipCodec;

import java.io.IOException;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.SequenceFile.Writer;
import org.apache.hadoop.io.compress.GzipCodec;



public class SequenceReader {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        System.out.println("Iniyan");

        Configuration config = new Configuration();
        //first.seq: 307
        //second.seq: 31
//        String hdfsRoot = "hdfs://100.127.6.32:9000";
//        String uri = hdfsRoot+"/data/hub/vehicle/US-MKZ-0002/2018/09/13/02/27/55/lidar/ros/lidarRosVelodyneCombined.seq";
//        Path path = new Path(URI.create(uri));


        String basePath = "/Users/iniyan.paramasivam/scale/US-MKZ-0002/2018/09/13/02/27/55/lidar/ros/";

        Path path = new Path(basePath + "lidarros.seq");
        SequenceFile.Reader reader = null;
        try {
            reader = new SequenceFile.Reader(FileSystem.get(config), path, config);
            SequenceFile.Writer writer = null;
            Path outFile = new Path(basePath + "result.seq");
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(conf);


            writer = new SequenceFile.Writer(fs,conf, outFile, LongWritable.class, reader.getValueClass());
//            IntWritable key = new IntWritable();
//            Text value = new Text();

            WritableComparable key = (WritableComparable) reader.getKeyClass().newInstance();
            Writable value = (Writable) reader.getValueClass().newInstance();
            int count = 0;

            LongWritable wkey = new LongWritable();
            BytesWritable wvalue = new BytesWritable();

            while (reader.next(key, value)) {
//                String keyInt = key.toString().split(".");
                long keyLong = Long.parseLong(key.toString().substring(0,key.toString().indexOf('.')));
                count++;
                System.out.println(keyLong);

                wkey.set(keyLong);
                wvalue.set((BytesWritable) value);
                writer.append(wkey, wvalue);

//                System.out.println(value);
                if(count == 250) break;
//                if(keyLong >= 1536804893209003000L && keyLong <= 1536804939145767000L){
//
//                    System.out.println(keyLong);
//                    count++;
//                }

            }
            writer.close();

            System.out.println(count);
            reader.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
