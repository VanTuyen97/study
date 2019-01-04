# print()
# write()
# sys.stdout
from msilib.schema import File

class File:
    def __init__(self, path, mode):
        """
        Mode::
        'r'       open for reading (default)
        'w'       open for writing, truncating the file first
        'x'       create a new file and open it for writing
        'a'       open for writing, appending to the end of the file if it exists
        'b'       binary mode
        't'       text mode (default)
        '+'       open a disk file for updating (reading and writing)
        'U'       universal newline mode (deprecated)
        """
        self.file = open(path, mode)

    def read_all_file(self):
        if self.is_close():
            return None
        return self.file.read()

    def read_one_line(self):
        if self.is_close():
            return None
        return self.file.readline()

    def write_line(self, content):
        if self.is_close():
            return None
        return self.file.writelines('\n' + content)

    def is_close(self):
        return self.file.closed

    def close(self):
        self.file.close()


if __name__ == '__main__':
    file = File("./resources/readme.txt", "a")
    # print(file.read_one_line())
    # print(file.read_one_line())
    # print(file.read_one_line())
    file.write_line("Hello tuyen!")
    file.close()
