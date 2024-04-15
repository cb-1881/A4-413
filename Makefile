JAVAC=javac
JAVA=java
CLASSPATH=dep/*:classes
SRC_DIR=src
BUILD_DIR=classes

all: clean compile run

clean:
	@echo "Cleaning..."
	@rm -rf $(BUILD_DIR)/*.class
	@rm -rf BST.png

compile:
	@echo "Compiling..."
	@$(JAVAC) -cp "$(CLASSPATH)" -d $(BUILD_DIR) $(SRC_DIR)/*.java

run:
	@echo "Running..."
	@$(JAVA) -cp "dep/*:classes" BinSearch

test:
	@echo "Running tests..."
	@java -cp "$(CLASSPATH)" org.junit.runner.JUnitCore BinSearchTest

.PHONY: all clean compile run