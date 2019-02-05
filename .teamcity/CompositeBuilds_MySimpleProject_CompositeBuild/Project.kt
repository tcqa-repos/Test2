package CompositeBuilds_MySimpleProject_CompositeBuild

import CompositeBuilds_MySimpleProject_CompositeBuild.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project

object Project : Project({
    id("CompositeBuilds_MySimpleProject_CompositeBuild")
    parentId("CompositeBuilds_MySimpleProject")
    name = "Composite Build"

    buildType(CompositeBuilds_MySimpleProject_CompositeBuild_AllTests)
    buildType(CompositeBuilds_MySimpleProject_CompositeBuild_AllTestsNotComposite)
})
