/*
 * Copyright 2011 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaplanner.examples.nqueens.domain;

// import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.optaplanner.examples.common.domain.AbstractPersistable;

// @XStreamAlias("Column")
public class Column extends AbstractPersistable {
    private int idx;
    private int T_clue; // Top clue.
    private int B_clue; // Bottom clue.



    /** Initialize column: **/
    public Column() {
        super();        // Calls immediate parent constructor for superclass AbstractPersistable.
        this.idx = -1;
        this.T_clue = -1;
        this.B_clue = -1;
    }



    /** Set and get column index: **/
    // public void set_idx(int idx) { :: Replaced with identifier used by NQueens.
    public void setIndex(int idx) {
        this.idx = idx;
    }

    // public int get_idx() { :: Replaced with identifier used by NQueens.
    public int getIndex() {
        return this.idx;
    }



    /** Set and get column top clue: **/
    public void set_T_clue(int T_clue) {
        this.T_clue = T_clue;
    }

    public int get_T_clue() {
        return this.T_clue;
    }



    /** Set and get column bottom clue: **/
    public void set_B_clue(int B_clue) {
        this.B_clue = B_clue;
    }

    public int get_B_clue() {
        return this.B_clue;
    }



    /** Return a string with column index for debugging: **/
    public String print_idx() {
        // "Column[idx]":
        return "Column[" + this.idx + "]";
    }



    /**
    /// This override is already done in the class Column, so this is an analogous method without any overriding.
    @Override // Overrides method from superclass AbstractPersistable, which is obligatory.
    public String getLabel() {
    **/
}
