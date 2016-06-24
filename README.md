# ECHO
Efficient Semi-Supervised Adaptive Classification and Novel Class Detection over Data Stream

## Synopsis
ECHO is a semi-supervised framework for classifying evolving data streams based on our previous approach SAND. The most expensive module of SAND is the change detection module, which has cubic time complexity. ECHO uses dynamic 
programming to reduce the time complexity. Moreover, ECHO has a maximum allowable sliding window size. If there is no concept drift detected within this limit, ECHO updates the classifiers and resets the sliding window. Experiment results show that ECHO achieves significant speed up over SAND while maintaining similar accuracy. Please refer to the paper (mentioned in the reference section) for further details. 

## Requirements
ECHO requires that-
* Input file will be provided in a ARFF format.
* All the features need to be numeric. If there is a non-numeric featues, those can be converted to numeric features using standard techniques.
* Features should be normalized to get better performance. 

## Environment
* Java SDK v1.7+
* Weka 3.6+
* Common Math library v2.2
* Apache Logging Services v1.2.15

All of above except java sdk are included inside SRC_ECHO_v_0_1 & DIST_ECHO_v_0_1 folder.

## Execution
To execute the program in a windows operating system:
1. Open a command prompt inside DIST_ECHO_v_0_1 folder folder.
2. Run the command ``java -cp ECHO_v_0_1.jar [OPTION]''

Options are following:
* -F 
 * Input file path. Do not include file extension .arff in the file path.
* -L
 * Maximum number of models in the ensemble. Default value is 6.
* -U
 * Value for confidence threshold. Please refer to the paper for description of confidence threshold. Default value is 0.90.
* -D
 * use 1 here to execute ECHO-D, 0 to execute ECHO-F. Please refer to the paper for description about ECHO-D, and ECHO-F. Default value is 1.
* -T
 * Labeling delay in number of instances. Default value for classification only is 1. Use appropriate value for novel class detection.
* -C
 * Classification delay in number of instances. Default value for classification only is 0. Use appropriate value for novel class detection.
* -W
 * Maximum allowable window size. Default value is 3000.
* -A
 * Sensitivity (denoted by alpha). Default value is 0.001.
* -G
 * Value of gamma, which is used to calculate the cushion period. Default value is 0.5. 
* -R 
 * Relaxation parameter. It is used in the change detection procedure. Default value is same as the value of Sensitivity.
 
Optional options are following:
* -S
 * Size of warm-up period chunks. Default is 2000 instances.


## Output
# Console output
* The program shows progress or any change point detected in console. 
* At the end, it reports percentage of labeled data used.

# File output
1. .log file contains important debug information.
2. .tmpres file contains the error rates for each chunk.  There are six columns as follows:
 * Chunk #= The current chunk number. Each chunk contains 1000 instances.
 * FP= How many existing class instances misclassified as novel class in this chunk.
 * FN= How many novel class instances misclassified as existing class in this chunk.
 * NC= How many novel class instances are actually there in this chunk.
 * Err = How many instances are misclassified (including FP and FN) in this chunk.
 * GlobErr = % Err (cumulative) upto the current chunk.
3. .res file contains the summary result, i.e., the following error rates:
 * FP% = % of existing class instances misclassified as novel
 * FN% = % of novel class instances misclassified as existing class instances.
 * NC (total) = total number of (actual) novel class instances.
 * ERR% = % classification error (including FP, FN, and misclassification within existing class).

## Reference
[Efficient Handling of Concept Drift and Concept Evolution over Stream Data](http://icde2016.fi/papers.php)
