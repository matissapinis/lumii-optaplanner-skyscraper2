/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
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

package org.optaplanner.examples.meetingscheduling.app;

import java.io.File;

import org.junit.Test;
import org.optaplanner.core.config.solver.EnvironmentMode;
import org.optaplanner.examples.common.app.SolverPerformanceTest;
import org.optaplanner.examples.meetingscheduling.domain.MeetingSchedule;

public class MeetingSchedulingPerformanceTest extends SolverPerformanceTest<MeetingSchedule> {

    public MeetingSchedulingPerformanceTest(String moveThreadCount) {
        super(moveThreadCount);
    }

    @Override
    protected MeetingSchedulingApp createCommonApp() {
        return new MeetingSchedulingApp();
    }

    // ************************************************************************
    // Tests
    // ************************************************************************

    @Test(timeout = 600000)
    public void solveModel() {
        File unsolvedDataFile = new File("data/meetingscheduling/unsolved/50meetings-160timegrains-5rooms.xlsx");
        runSpeedTest(unsolvedDataFile, "-35hard/-86medium/-6090soft");
    }

    @Test(timeout = 600000)
    public void solveModelFastAssert() {
        File unsolvedDataFile = new File("data/meetingscheduling/unsolved/50meetings-160timegrains-5rooms.xlsx");
        runSpeedTest(unsolvedDataFile, "-36hard/-64medium/-5921soft", EnvironmentMode.FAST_ASSERT);
    }

}
