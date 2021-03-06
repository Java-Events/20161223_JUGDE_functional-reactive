package org.rapidpm.workshop.frp.m03_functional.v002_memoizing;

import org.rapidpm.workshop.frp.core.model.Memoizer;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Copyright (C) 2010 RapidPM
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created by RapidPM - Team on 10.12.16.
 */
public class M05V009 {


  public static <T1, T2, R> BiFunction<T1, T2, R> memorize(final BiFunction<T1, T2, R> biFunc) {
    return prepare(transform(biFunc));
  }

  private static <T1, T2, R> BiFunction<T1, T2, R> prepare( final Function<T1, Function<T2, R>> transformed) {
    return (x, y) -> transformed.apply(x).apply(y);
  }

  private static <T1, T2, R> Function<T1, Function<T2, R>> transform(final BiFunction<T1, T2, R> biFunc) {
    return create((x, y) -> () -> biFunc.apply(x, y));
  }

  private static <T1, T2, R> Function<T1, Function<T2, R>> create(final BiFunction<T1, T2, Supplier<R>> biFuncSupplier) {
    return Memoizer.memoize(x -> Memoizer.memoize(y -> biFuncSupplier.apply(x, y).get()));
  }

  public static void main(String[] args) {
    final BiFunction<Integer, Integer, Integer> function = memorize((x, y) -> {
      System.out.println("execute x/y = " + x + " / " + y);
      return x * y;
    });

    System.out.println("memoizationFunction = " + function.apply(2,3));
    System.out.println("memoizationFunction = " + function.apply(2,3));
  }



}
