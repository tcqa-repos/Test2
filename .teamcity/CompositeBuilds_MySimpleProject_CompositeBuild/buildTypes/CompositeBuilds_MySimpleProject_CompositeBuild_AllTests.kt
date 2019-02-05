package CompositeBuilds_MySimpleProject_CompositeBuild.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildFeatures.freeDiskSpace
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.failureConditions.BuildFailureOnMetric
import jetbrains.buildServer.configs.kotlin.v2018_2.failureConditions.BuildFailureOnText
import jetbrains.buildServer.configs.kotlin.v2018_2.failureConditions.failOnMetricChange
import jetbrains.buildServer.configs.kotlin.v2018_2.failureConditions.failOnText

object CompositeBuilds_MySimpleProject_CompositeBuild_AllTests : BuildType({
    name = "All tests"

    artifactRules = "**/*"
    type = BuildTypeSettings.Type.COMPOSITE

    vcs {
        showDependenciesChanges = true
    }

    steps {
        script {
            scriptContent = "echo foo"
        }
    }

    failureConditions {
        executionTimeoutMin = 10
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
            metric = BuildFailureOnMetric.MetricType.ARTIFACT_SIZE
            units = BuildFailureOnMetric.MetricUnit.DEFAULT_UNIT
            comparison = BuildFailureOnMetric.MetricComparison.MORE
            compareTo = value()
            param("metricThreshold", "2MB")
            param("anchorBuild", "lastSuccessful")
        }
        failOnText {
            conditionType = BuildFailureOnText.ConditionType.CONTAINS
            pattern = "aaaaaaa"
            failureMessage = "failed"
            reverse = true
        }
        failOnText {
            conditionType = BuildFailureOnText.ConditionType.CONTAINS
            pattern = "rrrr"
            failureMessage = "failed 2"
            reverse = true
        }
    }

    features {
        freeDiskSpace {
            requiredSpace = "300GB"
            failBuild = false
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

    requirements {
        equals("system.agent.name", "aa")
    }
})
