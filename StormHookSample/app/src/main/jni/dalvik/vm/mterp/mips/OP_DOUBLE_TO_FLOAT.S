%verify "executed"
%include "mips/unopNarrower.S" {"instr":"JAL(__truncdfsf2)", "instr_f":"cvt.s.d fv0, fa0"}
