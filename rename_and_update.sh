#!/bin/bash

# Script to rename folders to lowercase and update package declarations
# Usage: ./rename_and_update.sh <directory>

DIR=$1

if [ -z "$DIR" ]; then
    echo "Usage: $0 <directory>"
    exit 1
fi

echo "Processing directory: $DIR"

# Step 1: Rename all subdirectories to lowercase recursively
find "$DIR" -depth -type d | while read dir; do
    parent=$(dirname "$dir")
    base=$(basename "$dir")
    lower=$(echo "$base" | tr '[:upper:]' '[:lower:]' | tr ' ' '_')
    
    if [ "$base" != "$lower" ]; then
        echo "Renaming: $dir -> $parent/$lower"
        mv "$dir" "$parent/$lower" 2>/dev/null || true
    fi
done

# Step 2: Update package declarations in all Java files
find "$DIR" -name "*.java" -type f | while read file; do
    # Get the package path from file location
    rel_path=$(dirname "$file" | sed "s|^$DIR/||" | tr '/' '.')
    
    # Update package declaration
    sed -i '' "1s/^package .*/package $rel_path;/" "$file" 2>/dev/null || true
done

echo "Done processing $DIR"
