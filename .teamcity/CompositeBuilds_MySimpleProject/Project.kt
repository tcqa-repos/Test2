package CompositeBuilds_MySimpleProject

import CompositeBuilds_MySimpleProject.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project

object Project : Project({
    id("CompositeBuilds_MySimpleProject")
    parentId("CompositeBuilds")
    name = "My Simple Project"

    buildType(CompositeBuilds_MySimpleProject_AllTests)
    buildType(CompositeBuilds_MySimpleProject_DependOnAllTests)
})
