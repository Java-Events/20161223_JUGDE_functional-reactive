package org.rapidpm.workshop.frp.d001;

import java.time.LocalDateTime;

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
 * Created by RapidPM - Team on 23.12.16.
 */
public class MyClass {

  public static final SubClass SUB_CLASS_02 = new SubClass();
  public static final SubClass SUB_CLASS_01 = new SubClass();

  static { System.out.println("static01 = " + LocalDateTime.now()); }
  static { System.out.println("static02 = " + LocalDateTime.now()); }

  { System.out.println("non-static01 = " + LocalDateTime.now()); }
  { System.out.println("non-static02 = " + LocalDateTime.now()); }


  public final SubClass subClass01 = new SubClass();
  public final SubClass subClass02 = new SubClass();

  public MyClass() {
    System.out.println("constructor = " + LocalDateTime.now());
  }


  public static void main(String[] args) {
    new MyClass();
  }

  public static class SubClass {
    public SubClass() {
      System.out.println("SubClass - constructor = " + LocalDateTime.now());
    }
  }

}
