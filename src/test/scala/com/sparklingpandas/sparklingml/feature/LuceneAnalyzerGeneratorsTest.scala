/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sparklingpandas.sparklingml.feature

import sys.process._

import org.scalatest._

class LuceneAnalyzerGeneratorsTest extends FunSuite with Matchers{
  test("verify the generated code is up to date") {
    LuceneAnalyzerGenerators.main(Array[String]())
    val basePath = "scala/com/sparklingpandas/sparklingml/feature/"
    val testResult = s"git diff -q ./src/test/${basePath}LuceneAnalyzersTests.scala".!
    val transformResult = s"git diff -q ./src/main/${basePath}LuceneAnalyzers.scala".!
    testResult shouldBe 0
    transformResult shouldBe 0
  }
}
