package CompositeBuilds_SubProject_SubSubProject

import CompositeBuilds_SubProject_SubSubProject.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project

object Project : Project({
    id("CompositeBuilds_SubProject_SubSubProject")
    parentId("CompositeBuilds_SubProject")
    name = "SubSubProject"

    buildType(CompositeBuilds_SubProject_SubSubProject_Tests2_2)
})
