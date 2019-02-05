package CompositeBuilds

import CompositeBuilds.buildTypes.*
import CompositeBuilds.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project
import jetbrains.buildServer.configs.kotlin.v2018_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2018_2.projectFeatures.versionedSettings

object Project : Project({
    id("CompositeBuilds")
    parentId("_Root")
    name = "Composite Builds"

    vcsRoot(CompositeBuilds_HttpsTcqaReposBitbucketOrgTcqaReposMyproject3git)

    buildType(CompositeBuilds_AllTests)
    buildType(CompositeBuilds_AllTestsR)
    buildType(CompositeBuilds_AllTests1)
    buildType(CompositeBuilds_AggregatingBuild)
    buildType(CompositeBuilds_AllTestsNoArtifacts)
    buildType(CompositeBuilds_CheckGitFetch)

    features {
        versionedSettings {
            id = "PROJECT_EXT_1"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.USE_CURRENT_SETTINGS
            rootExtId = "HttpsGithubComTcqaReposVersionedSettings"
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
            storeSecureParamsOutsideOfVcs = true
        }
        feature {
            id = "PROJECT_EXT_40"
            type = "buildtype-graphs"
            param("series", """
                [
                  {
                    "type": "valueType",
                    "title": "Artifacts Size",
                    "key": "VisibleArtifactsSize"
                  }
                ]
            """.trimIndent())
            param("format", "text")
            param("title", "New chart title")
            param("seriesTitle", "Serie")
        }
        feature {
            id = "PROJECT_EXT_41"
            type = "JetBrains.SharedResources"
            param("quota", "1")
            param("name", "quota")
            param("id", "PROJECT_EXT_41")
            param("type", "quoted")
            param("enabled", "true")
        }
        feature {
            id = "PROJECT_EXT_44"
            type = "JetBrains.SharedResources"
            param("quota", "-1")
            param("name", "testResource")
            param("type", "quoted")
        }
        feature {
            id = "PROJECT_EXT_45"
            type = "JetBrains.SharedResources"
            param("values", "aaa")
            param("name", "value")
            param("type", "custom")
        }
    }
})
