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
import org.optaplanner.examples.common.swingui.components.Labeled;

// @XStreamAlias("Row")
public class Row extends AbstractPersistable implements Labeled {
    private int idx;
    private int L_clue; // Left clue.
    private int R_clue; // Right clue.



    /** Initialize row: **/
    public Row() {
        super();        // Calls immediate parent constructor for superclass AbstractPersistable.
        this.idx = -1;
        this.L_clue = -1;
        this.R_clue = -1;
    }



    /** Set and get row index: **/
    public void set_idx(int idx) {
        this.idx = idx;
    }

    public int get_idx() {
        return this.idx;
    }



    /** Set and get row left clue: **/
    public void set_L_clue(int L_clue) {
        this.L_clue = L_clue;
    }

    public int get_L_clue() {
        return this.L_clue;
    }



    /** Set and get row right clue: **/
    public void set_R_clue(int R_clue) {
        this.R_clue = R_clue;
    }

    public int get_R_clue() {
        return this.R_clue;
    }



    /** Return a string with the row index for debugging: **/
    @Override // Obligatory override for method from implemented class Labeled in superclass AbstractPersistable.
    public String getLabel() {
        // "Row[idx]":
        return ("Row[" + this.idx + "]");
    }
}
