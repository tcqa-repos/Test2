package CompositeBuilds_MySimpleProject_CompositeBuild.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.failureConditions.BuildFailureOnMetric
import jetbrains.buildServer.configs.kotlin.v2018_2.failureConditions.BuildFailureOnText
import jetbrains.buildServer.configs.kotlin.v2018_2.failureConditions.failOnMetricChange
import jetbrains.buildServer.configs.kotlin.v2018_2.failureConditions.failOnText

object CompositeBuilds_MySimpleProject_CompositeBuild_AllTestsNotComposite : BuildType({
    name = "All tests (not composite)"

    artifactRules = "**/*"

    vcs {
        showDependenciesChanges = true
    }

    steps {
        step {
            type = "SleepNSeconds"
            param("timeout-in-seconds", "20")
        }
    }

    failureConditions {
        failOnMetricChange {
            metric = BuildFailureOnMetric.MetricType.TEST_COUNT
            units = BuildFailureOnMetric.MetricUnit.DEFAULT_UNIT
            comparison = BuildFailureOnMetric.MetricComparison.MORE
            compareTo = value()
            param("anchorBuild", "lastSuccessful")
        }
        failOnMetricChange {
            metric = BuildFailureOnMetric.MetricType.TEST_FAILED_COUNT
            threshold = 0
            units = BuildFailureOnMetric.MetricUnit.DEFAULT_UNIT
            comparison = BuildFailureOnMetric.MetricComparison.MORE
            compareTo = value()
            param("anchorBuild", "lastSuccessful")
        }
        failOnMetricChange {
            metric = BuildFailureOnMetric.MetricType.COVERAGE_CLASS_COUNT
            threshold = 10
            units = BuildFailureOnMetric.MetricUnit.DEFAULT_UNIT
            comparison = BuildFailureOnMetric.MetricComparison.LESS
            compareTo = value()
            param("anchorBuild", "lastSuccessful")
        }
        failOnMetricChange {
            metric = BuildFailureOnMetric.MetricType.TEST_DURATION
            units = BuildFailureOnMetric.MetricUnit.DEFAULT_UNIT
            comparison = BuildFailureOnMetric.MetricComparison.MORE
            compareTo = value()
            param("anchorBuild", "lastSuccessful")
        }
        failOnMetricChange {
            metric = BuildFailureOnMetric.MetricType.ARTIFACTS_TOTAL_SIZE
            units = BuildFailureOnMetric.MetricUnit.DEFAULT_UNIT
            comparison = BuildFailureOnMetric.MetricComparison.LESS
            compareTo = value()
            param("metricThreshold", "100MB")
            param("anchorBuild", "lastSuccessful")
        }
        failOnText {
            conditionType = BuildFailureOnText.ConditionType.CONTAINS
            pattern = "test"
            failureMessage = "failed"
            reverse = true
        }
    }

    dependencies {
        dependency(CompositeBuilds_MySimpleProject_NewSubProject.buildTypes.CompositeBuilds_MySimpleProject_NewSubProject_Tests2) {
            snapshot {
            }

            artifacts {
                artifactRules = "artifact.zip"
            }
        }
        dependency(CompositeBuilds_MySimpleProject_NewSubProject.buildTypes.CompositeBuilds_MySimpleProject_NewSubProject_Tests21) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }

            artifacts {
                artifactRules = "artifact.zip"
            }
        }
        dependency(CompositeBuilds_MySimpleProject_SubProject.buildTypes.CompositeBuilds_MySimpleProject_SubProject_Tests1) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }

            artifacts {
                artifactRules = "*"
            }
        }
        snapshot(CompositeBuilds_MySimpleProject_SubProject.buildTypes.CompositeBuilds_MySimpleProject_SubProject_Tests2) {
            reuseBuilds = ReuseBuilds.NO
        }
    }
})
