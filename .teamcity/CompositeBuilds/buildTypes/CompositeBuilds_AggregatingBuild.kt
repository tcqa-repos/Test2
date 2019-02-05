package CompositeBuilds.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*

object CompositeBuilds_AggregatingBuild : BuildType({
    name = "Aggregating build"

    type = BuildTypeSettings.Type.COMPOSITE

    dependencies {
        snapshot(AbsoluteId("BuildRunners_Ant_TestTasksWithJacoco")) {
            reuseBuilds = ReuseBuilds.NO
        }
        snapshot(AbsoluteId("BuildRunners_Gradle_ParallelBuild")) {
            reuseBuilds = ReuseBuilds.NO
        }
        snapshot(AbsoluteId("BuildRunners_Gradle_ParallelExecution")) {
            reuseBuilds = ReuseBuilds.NO
        }
        snapshot(AbsoluteId("BuildRunners_Tests_MSTest_TestsReportedViaServiceMessages")) {
            reuseBuilds = ReuseBuilds.NO
            onDependencyCancel = FailureAction.ADD_PROBLEM
        }
        snapshot(AbsoluteId("BuildRunners_Tests_TestsReportedViaServiceMessages_1reportedTest")) {
            reuseBuilds = ReuseBuilds.NO
            onDependencyCancel = FailureAction.ADD_PROBLEM
        }
        snapshot(AbsoluteId("BuildRunners_Tests_TestsReportedViaServiceMessages_3reportedTests")) {
            reuseBuilds = ReuseBuilds.NO
            onDependencyCancel = FailureAction.ADD_PROBLEM
        }
        snapshot(AbsoluteId("BuildRunners_Tests_TestsReportedViaServiceMessages_Tests")) {
            reuseBuilds = ReuseBuilds.NO
            onDependencyCancel = FailureAction.ADD_PROBLEM
        }
        snapshot(AbsoluteId("BuildRunners_Tests_TestsReportedViaServiceMessages_Tests1")) {
            reuseBuilds = ReuseBuilds.NO
            onDependencyCancel = FailureAction.ADD_PROBLEM
        }
        snapshot(AbsoluteId("BuildRunners_Tests_TestsRetry")) {
            reuseBuilds = ReuseBuilds.NO
            onDependencyCancel = FailureAction.ADD_PROBLEM
        }
        snapshot(AbsoluteId("Calculator_Build")) {
            reuseBuilds = ReuseBuilds.NO
            onDependencyCancel = FailureAction.ADD_PROBLEM
        }
        snapshot(AbsoluteId("Gradle_Build")) {
            reuseBuilds = ReuseBuilds.NO
            onDependencyCancel = FailureAction.ADD_PROBLEM
        }
        snapshot(AbsoluteId("SimpleMavenSample_Build")) {
            reuseBuilds = ReuseBuilds.NO
            onDependencyCancel = FailureAction.ADD_PROBLEM
        }
    }
})
