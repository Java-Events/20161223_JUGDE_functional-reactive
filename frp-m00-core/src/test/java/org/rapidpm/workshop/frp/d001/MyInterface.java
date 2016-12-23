package org.rapidpm.workshop.frp.d001;

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
@FunctionalInterface
public interface MyInterface {

  public void doWork01();
  public default void doWork02(){
    doPrivateWork();
  }
  //since 9
  private void doPrivateWork(){}
  public static void doStaticWork01(){ };
  public static String MY_STRING = "blub";


}
