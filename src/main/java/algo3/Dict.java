package algo3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paramin on 8/24/17.
 */
public class Dict {
    List<Pair> pairs;

    Dict() {
        this.pairs = new ArrayList<>();
    }

    Dict(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public Dict flatten(Dict dict) {
        Dict new_dict = new Dict();
        for (Pair pair : dict.pairs) {
            if (pair.value == null)
                new_dict.pairs.add(pair);
            else
                new_dict.pairs.addAll(combine(pair.key, flatten(pair.value)));
        }
        return new_dict;
    }

    List<Pair> combine(String key, Dict value) { //here value is a flattened dict
        List<Pair> pairs = new ArrayList<Pair>();
        for (Pair pair : value.pairs) {
            pairs.add(new Pair(key + "_" + pair.key, pair.value));
        }
        return pairs;
    }

//    public static void main(String[] args) {
//            Pair p = new Pair("b","c")
//    }
}

class Pair {
    String key;
    Dict value;

    Pair(String key, Dict value){
        this.key = key;
        this.value = value;
    }
}

