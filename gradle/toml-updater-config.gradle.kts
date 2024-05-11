versionCatalogUpdate {
    // sort the catalog by key (default is true)
    sortByKey.set(true)
    // Referenced that are pinned are not automatically updated.
    // They are also not automatically kept however (use keep for that).
    pin {
        /* // pins all libraries and plugins using the given versions
        versions.add("my-version-name")
        versions.add("other-version")
        // pins specific libraries that are in the version catalog
        libraries.add(libs.my.library.reference)
        libraries.add(libs.my.other.library.reference)
        // pins specific plugins that are in the version catalog
        plugins.add(libs.plugins.my.plugin)
        plugins.add(libs.plugins.my.other.plugin)
        // pins all libraries (not plugins) for the given groups
        groups.add("com.somegroup")
        groups.add("com.someothergroup")*/
    }
    keep {
       /* // keep has the same options as pin to keep specific entries
        versions.add("my-version-name")
        versions.add("other-version")
        libraries.add(libs.my.library.reference)
        libraries.add(libs.my.other.library.reference)
        plugins.add(libs.plugins.my.plugin)
        plugins.add(libs.plugins.my.other.plugin)
        groups.add("com.somegroup")
        groups.add("com.someothergroup")*/

        // keep versions without any library or plugin reference
        keepUnusedVersions.set(true)
        // keep all libraries that aren't used in the project
        keepUnusedLibraries.set(true)
        // keep all plugins that aren't used in the project
        keepUnusedPlugins.set(true)
    }
}