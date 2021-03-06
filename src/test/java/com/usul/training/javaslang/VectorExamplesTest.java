package com.usul.training.javaslang;

import javaslang.Tuple2;
import javaslang.collection.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * VectorExamplesTest
 *
 * @author bigkahuna
 * @since 30/10/2016
 */
public class VectorExamplesTest {

    private Vector<Integer> vector;

    @BeforeEach
    public void setup() {

        vector = Vector.of(1, 2, 3, 4, 5);
    }

    @DisplayName("should prepend the new element")
    @Test
    public void prepend() {

        Vector<Integer> list2 = vector.tail().prepend(0);

        assertThat(list2).containsExactly(0, 2, 3, 4, 5);
    }

    @Test
    public void clear() {
        Vector cleared = vector.clear();

        assertThat(cleared).isEmpty();
        assertThat(vector).isNotEmpty();
    }

    @Test
    public void drop() {
        Vector<Integer> dropped = vector.drop(2);

        assertThat(dropped).containsOnly(3, 4, 5);
    }

    @Test
    public void dropRight() {
        Vector dropped = vector.dropRight(2);

        assertThat(dropped).containsOnly(1, 2, 3);
    }

    @Test
    public void partition() {
        Tuple2<Vector<Integer>, Vector<Integer>> tuple2 = vector.partition(i -> i % 2 == 0);

        assertThat(tuple2._1).containsOnly(2, 4);
        assertThat(tuple2._2).doesNotContain(2, 4);

    }


}
