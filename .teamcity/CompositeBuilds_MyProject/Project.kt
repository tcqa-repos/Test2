package CompositeBuilds_MyProject

import CompositeBuilds_MyProject.buildTypes.*
import CompositeBuilds_MyProject.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project

object Project : Project({
    id("CompositeBuilds_MyProject")
    parentId("CompositeBuilds")
    name = "My Project"

    vcsRoot(CompositeBuilds_MyProject_HttpsGithubComTcqaReposCalculator)
    vcsRoot(CompositeBuilds_MyProject_HttpsGithubComTcqaReposGradleRefsHeadsMaster)

    buildType(CompositeBuilds_MyProject_DependOnAllTests)
    buildType(CompositeBuilds_MyProject_BuildWithDuplicates)
    buildType(CompositeBuilds_MyProject_AllTests)

    features {
        feature {
            id = "PROJECT_EXT_28"
            type = "project-graphs"
            param("series", """
                [
                  {
                    "type": "valueType",
                    "title": "Number of Failed Tests",
                    "sourceBuildTypeId": "CompositeBuilds8_MyProject_BuildWithDuplicates",
                    "key": "FailedTestCount"
                  },
                  {
                    "type": "valueType",
                    "title": "Build Checkout Time",
                    "key": "buildStageDuration:sourcesUpdate"
                  },
                  {
                    "type": "valueType",
                    "title": "BuildTestStatus",
                    "key": "BuildTestStatus"
                  }
                ]
            """.trimIndent())
            param("format", "text")
            param("title", "Chart title")
            param("seriesTitle", "Serie")
        }
        feature {
            id = "PROJECT_EXT_39"
            type = "project-graphs"
            param("series", """
                [
                  {
                    "type": "valueType",
                    "title": "Code Duplicates",
                    "sourceBuildTypeId": "CompositeBuilds8_MyProject_BuildWithDuplicates",
                    "key": "DuplicatorStats"
                  }
                ]
            """.trimIndent())
            param("format", "text")
            param("title", "My code duplicates")
            param("seriesTitle", "Serie")
        }
    }
})
