package com.acrylic.exceptions

class UnsupportedFileTypeException : RuntimeException() {
    override fun toString(): String {
        return "UnsupportedFileTypeException: FileFactory only accepts .yml or .json."
    }
}