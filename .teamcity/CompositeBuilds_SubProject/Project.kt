package CompositeBuilds_SubProject

import CompositeBuilds_SubProject.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project

object Project : Project({
    id("CompositeBuilds_SubProject")
    parentId("CompositeBuilds")
    name = "SubProject"

    buildType(CompositeBuilds_SubProject_Tests2)
    buildType(CompositeBuilds_SubProject_Tests1)
})
