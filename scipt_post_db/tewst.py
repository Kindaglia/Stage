
import subprocess
import sys
import os

def add_to_PATH(paths):
    # create the paths to add to the PATH
    path_to_add = ""
    for path in paths:
        path_to_add += path + os.pathsep
               
    result = subprocess.run(['setx', 'PATH', os.environ['PATH'] + os.pathsep + path_to_add], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    if len(result.stdout):
        print(result.stdout.decode("utf-8"))
    if len(result.stderr):
        print("Error occured setting PATH - {}".format(result.stderr.decode("utf-8")))

def get_python_paths():

    # find the python path based on the exe
    python_exe_path = sys.executable
    python_path = os.path.dirname(python_exe_path)
    
    # find the python scripts path
    scripts_path = None
    current_path = python_path
    searched = False
    while searched == False:
        path_to_test = os.path.join(current_path, "Scripts")
        if os.path.isdir(path_to_test):
            searched = True
            scripts_path = path_to_test
        else:
            current_path = os.path.dirname(current_path)
            # have we reached the top level
            if os.path.splitdrive(current_path)[1] == "":
                searched = True

    if scripts_path is None:
        raise Exception("failed to find python and scripts path")

    return (python_path, scripts_path)

add_to_PATH(get_python_paths())