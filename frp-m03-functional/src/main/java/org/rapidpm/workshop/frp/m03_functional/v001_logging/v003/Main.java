package org.rapidpm.workshop.frp.m03_functional.v001_logging.v003;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.lang.System.out;

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
 * Created by RapidPM - Team on 18.10.16.
 */
public class Main {

  public static void main(String[] args) {

    final List<String> names = Arrays.asList(
        "Hugo",
        "Willy",
        "Simon",
        "Erwin",
        "Sigfried"
    );


//    Function<String, Predicate<String>> funPredicate = (str) -> {
//      return new Predicate<String>() {
//        @Override
//        public boolean test(final String s) {
//          return s.contains(str);
//        }
//      };
//    };

    final Consumer<String> println = out::println;

    final Function<String, Predicate<String>> funPredicate
        = str -> (String s) -> s.contains(str);

    names
        .stream()
        .filter(funPredicate.apply("i"))
        .forEach(println);

    out.println("names = " + names);

    names
        .stream()
        .filter(funPredicate.apply("g"))
        .forEach(println);
  }
}
