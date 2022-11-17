/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.reactor;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.stream.Stream;

public class ReactorTest {
    public static void main(String[] args) {
        //just方法直接声明
        Flux.just(1, 2, 3, 4).subscribe(System.out::print);
        Mono.just(1);

        Integer[] arr = {1, 2, 3, 4};
        Flux.fromArray(arr);

        List<Integer> list = Arrays.asList(arr);
        Flux.fromIterable(list);

        Stream<Integer> stream = list.stream();
        Flux.fromStream(stream);
    }

}
