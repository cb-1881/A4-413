JAVAC=javac
JAVA=java
CLASSPATH=dep/*:classes
SRC_DIR=src
BUILD_DIR=classes

all: clean compile run

clean:
	@echo "Cleaning..."
	@rm -rf $(BUILD_DIR)/*.class

compile:
	@echo "Compiling..."
	@$(JAVAC) -cp "$(CLASSPATH)" -d $(BUILD_DIR) $(SRC_DIR)/*.java

run:
	@echo "Running..."
	@$(JAVA) -cp "dep/*:classes" BinSearch


.PHONY: all clean compile run dropTables