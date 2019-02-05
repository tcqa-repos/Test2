package CompositeBuilds_MySimpleProject_SubProject

import CompositeBuilds_MySimpleProject_SubProject.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project

object Project : Project({
    id("CompositeBuilds_MySimpleProject_SubProject")
    parentId("CompositeBuilds_MySimpleProject")
    name = "SubProject"

    buildType(CompositeBuilds_MySimpleProject_SubProject_Tests2)
    buildType(CompositeBuilds_MySimpleProject_SubProject_Tests1)
})
